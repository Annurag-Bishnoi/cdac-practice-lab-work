DELIMITER //

CREATE PROCEDURE SALARY_INCREASE(IN N INT)
BEGIN
    -- Declare local variables at the top
    DECLARE H DATE;

    -- Select the hire date into the variable
    SELECT HIREDATE INTO H
    FROM EMP 
    WHERE EMPNO = N;

    -- Check if the month is June (06) or earlier
    IF MONTH(H) <= 6 THEN
        UPDATE EMP 
        SET SAL = SAL + 200
        WHERE EMPNO = N;
        
        SELECT 'SAL INCREASED Rs 200/-' AS Message;
    ELSE
        UPDATE EMP 
        SET SAL = SAL + 100
        WHERE EMPNO = N;
        
        SELECT 'SAL INCREASED Rs 100/-' AS Message;
    END IF;
END //

DELIMITER ;