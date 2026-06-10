DELIMITER //

CREATE PROCEDURE UPDATE_STAFF_LEAVE()
BEGIN
    -- 1. Declare variables (matching the types of your columns)
    DECLARE done INT DEFAULT FALSE;
    DECLARE v_eno INT;
    DECLARE v_cla INT;
    DECLARE v_clt INT;

    -- 2. Declare the cursor with the JOIN
    DECLARE c1 CURSOR FOR 
        SELECT S.ENO, S.CLA, L.CLT
        FROM STAFF S
        INNER JOIN LEAVE L ON S.ENO = L.ENO;

    -- 3. Declare handler for the end of the cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN c1;

    read_loop: LOOP
        FETCH c1 INTO v_eno, v_cla, v_clt;

        IF done THEN
            LEAVE read_loop;
        END IF;

        -- 4. Perform the update
        UPDATE STAFF 
        SET CLA = v_cla - v_clt
        WHERE ENO = v_eno;

    END LOOP;

    CLOSE c1;
END //

DELIMITER ;
--------------------------------------
CALL UPDATE_STAFF_LEAVE();