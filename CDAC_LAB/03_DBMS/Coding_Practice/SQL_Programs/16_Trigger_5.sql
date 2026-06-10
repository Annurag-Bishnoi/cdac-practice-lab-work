DELIMITER //

CREATE TRIGGER SAL_INFO_UPDATE
AFTER UPDATE ON EMP
FOR EACH ROW
BEGIN
    -- Declare the variable for the salary difference
    DECLARE DIFF DECIMAL(10, 2);

    -- Perform the calculation
    SET DIFF = NEW.SAL - OLD.SAL;

    -- Insert into the audit table
    INSERT INTO SAL_DETAILS (
        EMPNO, ENAME, OLD_SAL, NEW_SAL, 
        DIFF_AMT, LOG_DATE, LOG_TIME
    )
    VALUES (
        OLD.EMPNO, 
        OLD.ENAME, 
        OLD.SAL, 
        NEW.SAL, 
        DIFF, 
        CURDATE(), 
        CURTIME()
    );
END //

DELIMITER ;