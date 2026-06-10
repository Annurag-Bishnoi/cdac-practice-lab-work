DELIMITER //

CREATE PROCEDURE PROCESS_DEPT_INCREASE(IN D_NO INT)
BEGIN
    -- 1. Declare variables
    DECLARE done INT DEFAULT FALSE;
    DECLARE emp_id INT;

    -- 2. Declare the cursor
    DECLARE C1 CURSOR FOR 
        SELECT EMPNO FROM EMP WHERE DEPTNO = D_NO;

    -- 3. Declare handler to exit loop when cursor is empty
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN C1;

    read_loop: LOOP
        FETCH C1 INTO emp_id;
        
        -- Check if the handler set 'done' to true
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- 4. Call your previously created procedure
        CALL DEPT_SAL_INCREASE(emp_id);
        
    END LOOP;

    CLOSE C1;
END //

DELIMITER ;

-------------------------------
CALL PROCESS_DEPT_INCREASE(10);