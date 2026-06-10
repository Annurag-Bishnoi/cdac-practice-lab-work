DELIMITER //

CREATE PROCEDURE ADJUST_DEPT_SALARIES(IN D_NO INT)
BEGIN
    -- 1. Declare local variables
    DECLARE done INT DEFAULT FALSE;
    DECLARE n_empno INT;
    DECLARE j_job VARCHAR(50);

    -- 2. Declare the cursor
    DECLARE c1 CURSOR FOR 
        SELECT EMPNO, JOB FROM EMP WHERE DEPTNO = D_NO;

    -- 3. Declare handler to stop the loop
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN c1;

    read_loop: LOOP
        FETCH c1 INTO n_empno, j_job;

        -- Exit loop if no more records
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- 4. Conditional logic for salary updates
        IF j_job = 'CLERK' OR j_job = 'SALESMAN' THEN
            UPDATE EMP SET SAL = SAL + 300 WHERE EMPNO = n_empno;
        
        ELSEIF j_job = 'MANAGER' THEN
            UPDATE EMP SET SAL = SAL + 200 WHERE EMPNO = n_empno;
        
        ELSE
            UPDATE EMP SET SAL = SAL + 100 WHERE EMPNO = n_empno;
        END IF;

    END LOOP;

    CLOSE c1;
END //

DELIMITER ;