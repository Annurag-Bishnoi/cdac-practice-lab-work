DELIMITER //

CREATE PROCEDURE RANK_TOP_STUDENTS()
BEGIN
    -- 1. Declare local variables
    DECLARE done INT DEFAULT FALSE;
    DECLARE n_stno INT;
    DECLARE m_marks INT;
    DECLARE r_rank INT DEFAULT 0;
    DECLARE x_count INT DEFAULT 0;

    -- 2. Declare the cursor
    DECLARE c1 CURSOR FOR 
        SELECT STNO, MARKS FROM STUDENTS 
        ORDER BY MARKS DESC;

    -- 3. Declare handler for end of records
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN c1;

    read_loop: LOOP
        FETCH c1 INTO n_stno, m_marks;

        -- Check if no more records exist
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Increment x_count to simulate Oracle's %ROWCOUNT
        SET x_count = x_count + 1;

        -- Exit loop if we've processed more than 3 students
        IF x_count > 3 THEN
            LEAVE read_loop;
        END IF;

        -- Increment rank and update table
        SET r_rank = r_rank + 1;
        UPDATE STUDENTS SET RANK = r_rank 
        WHERE STNO = n_stno;

    END LOOP;

    CLOSE c1;
END //

DELIMITER ;