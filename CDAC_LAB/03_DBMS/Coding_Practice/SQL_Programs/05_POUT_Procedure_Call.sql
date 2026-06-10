Calling Without cursor Program 
----------------------------------------
SET @my_sal = 0;
SET @my_comm = 0;

CALL POUT(7900, @my_sal, @my_comm);

SELECT @my_sal, @my_comm;


-----------------------------------------------------

Calling Procedure Wtih Cursor Program

DELIMITER //

CREATE PROCEDURE PROCESS_SALESMEN()
BEGIN
    -- Declare local variables (No %TYPE in MySQL)
    DECLARE v_empno INT;
    DECLARE v_sal DECIMAL(10,2);
    DECLARE v_comm DECIMAL(10,2);
    DECLARE done INT DEFAULT FALSE;

    -- Declare the Cursor
    DECLARE c1 CURSOR FOR 
        SELECT EMPNO, SAL, COMM 
        FROM EMP 
        WHERE JOB = 'SALESMAN';

    -- Declare the handler for when the cursor reaches the end
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN c1;

    read_loop: LOOP
        FETCH c1 INTO v_empno, v_sal, v_comm;

        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Call the previously created procedure
        -- Note: MySQL variables are passed by reference in INOUT
        CALL POUT(v_empno, v_sal, v_comm);

        -- Update the table with the new values returned from POUT
        UPDATE EMP 
        SET SAL = v_sal, 
            COMM = v_comm 
        WHERE EMPNO = v_empno;

    END LOOP;

    CLOSE c1;
END //

DELIMITER ;

-----------------------------------------

CALL PROCESS_SALESMEN();