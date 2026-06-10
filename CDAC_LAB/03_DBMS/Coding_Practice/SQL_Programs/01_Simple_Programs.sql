Simple Programs 

Program One(Simple Message)
--------------------------------------
DELIMITER //

CREATE PROCEDURE DisplayWelcome()
BEGIN
    SELECT 'WELCOME TO CDAC' AS Message;
END //

DELIMITER ;

-- To run it:
CALL DisplayWelcome();

Program Two(Simple Create)
------------------

DELIMITER //

CREATE PROCEDURE AddStudent(
    IN p_n INT, 
    IN p_m VARCHAR(15), 
    IN p_d DATE, 
    IN p_f DECIMAL(6,0)
)
BEGIN
    INSERT INTO STUDENT VALUES (p_n, p_m, p_d, p_f);
    SELECT 'ONE RECORD SAVED' AS Status;
END //

DELIMITER ;

-- To execute:
CALL AddStudent(10, 'John Doe', '2024-05-20', 5000);

Program Three(Create With Exceptions)
---------------------------------------------------

DELIMITER //

CREATE PROCEDURE SaveStudentRecord(
    IN p_stno INT, 
    IN p_stname VARCHAR(15), 
    IN p_doa DATE, 
    IN p_fees DECIMAL(10,2)
)
BEGIN
    -- 1. Handle Duplicate Key (Oracle's DUP_VAL_ON_INDEX)
    DECLARE CONTINUE HANDLER FOR 1062 -- Error code for Duplicate Entry
    BEGIN
        SELECT CONCAT('STNO ', p_stno, ' ALREADY EXISTS') AS ErrorMessage;
    END;

    -- 2. Handle Data Mismatch/Storage (Oracle's STORAGE_ERROR/Data issues)
    -- In MySQL, 1264 is Out of Range, 1366 is Incorrect Value
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        SELECT 'MISMATCH OF DATA OR DATABASE ERROR' AS ErrorMessage;
    END;

    -- The actual Logic
    INSERT INTO STUDENT (stno, stname, doa, fees) 
    VALUES (p_stno, p_stname, p_doa, p_fees);
    
    -- If no error occurred, this will show
    SELECT 'ONE RECORD SAVED' AS Status;

END //

DELIMITER ;

CALL SaveStudentRecord(101, 'Rahul', '2024-05-20', 5000);

Program Four(Read Operation)
----------------------------------------
DELIMITER //

CREATE PROCEDURE GetStudentDetails(IN p_stno INT)
BEGIN
    -- Declare local variables (explicit types instead of %TYPE)
    DECLARE v_stname VARCHAR(50);
    DECLARE v_doa DATE;
    DECLARE v_fees DECIMAL(10,2);
    DECLARE v_exists INT DEFAULT 1;

    -- Handle the "NO_DATA_FOUND" equivalent
    DECLARE CONTINUE HANDLER FOR NOT FOUND 
    BEGIN
        SET v_exists = 0;
    END;

    -- The Query
    SELECT STNAME, DOA, FEES 
    INTO v_stname, v_doa, v_fees 
    FROM STUDENT 
    WHERE STNO = p_stno;

    -- Logic for Output
    IF v_exists = 1 THEN
        SELECT 
            CONCAT('STNAME IS ', v_stname) AS Name,
            CONCAT('DATE OF ADMN IS ', v_doa) AS AdminDate,
            CONCAT('FEES IS ', v_fees) AS Fees;
    ELSE
        SELECT CONCAT('STNO ', p_stno, ' DOES NOT EXIST') AS ErrorMessage;
    END IF;

END //

DELIMITER ;

CALL GetStudentDetails(101);

Program Five(Update Operation)
----------------------------------------
DELIMITER //

CREATE PROCEDURE UpdateStudentFees(IN p_stno INT)
BEGIN
    -- 1. Perform the update directly
    UPDATE STUDENT 
    SET FEES = FEES + 500 
    WHERE STNO = p_stno;

    -- 2. Check if any row was actually changed
    -- ROW_COUNT() returns the number of rows affected by the last statement
    IF ROW_COUNT() > 0 THEN
        SELECT 'FEES CHANGED 500/-' AS Status;
    ELSE
        SELECT CONCAT('STNO ', p_stno, ' NOT FOUND') AS ErrorMessage;
    END IF;

END //

DELIMITER ;

CALL UpdateStudentFees(101);

--------------------------------------------
Program Six(Delete Operation)
DELIMITER //

CREATE PROCEDURE DeleteStudent(IN p_stno INT)
BEGIN
    -- 1. Execute the DELETE statement
    DELETE FROM STUDENT 
    WHERE STNO = p_stno;

    -- 2. Check if the deletion was successful
    -- ROW_COUNT() returns > 0 if a row was deleted
    IF ROW_COUNT() > 0 THEN
        SELECT 'ONE RECORD DELETED' AS Status;
    ELSE
        SELECT CONCAT('STNO ', p_stno, ' DOES NOT EXIST') AS ErrorMessage;
    END IF;

END //

DELIMITER ;

CALL DeleteStudent(105);