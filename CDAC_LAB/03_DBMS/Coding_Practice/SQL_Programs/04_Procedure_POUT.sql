DELIMITER //

CREATE PROCEDURE POUT(
    IN N INT, 
    INOUT NS DECIMAL(10,2), 
    INOUT NC DECIMAL(10,2)
)
BEGIN
    -- Fetch current salary and commission into the parameters
    SELECT SAL, COMM INTO NS, NC
    FROM EMP 
    WHERE EMPNO = N;

    -- Update the salary value
    SET NS = NS + 500;

    -- Update the commission value based on the logic
    IF NC > 0 THEN
        SET NC = NC + 50;
    ELSE
        SET NC = 0;
    END IF;
END //

DELIMITER ;