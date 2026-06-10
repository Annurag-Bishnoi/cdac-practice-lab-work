DELIMITER //

CREATE PROCEDURE DEPT_SAL_INCREASE(IN N INT)
BEGIN
    -- Declare local variable for salary
    DECLARE S DECIMAL(10,2);

    -- Retrieve current salary
    SELECT SAL INTO S 
    FROM EMP
    WHERE EMPNO = N;

    -- Conditional logic for salary increase
    IF S <= 1000 THEN
        UPDATE EMP 
        SET SAL = SAL + 200
        WHERE EMPNO = N;
        SELECT 'Salary increased by 200' AS Status;
    ELSE
        UPDATE EMP 
        SET SAL = SAL + 100
        WHERE EMPNO = N;
        SELECT 'Salary increased by 100' AS Status;
    END IF;
END //

DELIMITER ;