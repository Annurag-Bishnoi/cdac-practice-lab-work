DELIMITER //

CREATE FUNCTION F1(N INT) 
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE S DECIMAL(10,2);
    DECLARE NS DECIMAL(10,2);

    -- Retrieve current salary
    SELECT SAL INTO S 
    FROM EMP 
    WHERE EMPNO = N;

    -- Calculate new salary
    SET NS = S + 1000;

    RETURN NS;
END //

DELIMITER ;
---------------------------------------------------------------
cursor Program
------------------------
DELIMITER //

CREATE PROCEDURE ADJUST_SALARIES_VIA_FUNCTION()
BEGIN
    -- 1. Declare local variables
    DECLARE done INT DEFAULT FALSE;
    DECLARE n_empno INT;
    DECLARE cs_sal DECIMAL(10,2);
    DECLARE ns_sal DECIMAL(10,2);

    -- 2. Declare the cursor
    DECLARE c1 CURSOR FOR SELECT EMPNO, SAL FROM EMP;

    -- 3. Declare the handler for loop termination
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN c1;

    read_loop: LOOP
        FETCH c1 INTO n_empno, cs_sal;

        IF done THEN
            LEAVE read_loop;
        END IF;

        -- 4. Call the function F1 we created earlier
        SET ns_sal = F1(n_empno);

        -- 5. Conditional logic
        IF cs_sal < 5000 AND ns_sal < 5000 THEN
            UPDATE EMP SET SAL = ns_sal WHERE EMPNO = n_empno;
        
        ELSEIF cs_sal < 5000 AND ns_sal > 5000 THEN
            UPDATE EMP SET SAL = 5000 WHERE EMPNO = n_empno;
        END IF;

    END LOOP;

    CLOSE c1;
END //

DELIMITER ;

--------------------------------------
CALL ADJUST_SALARIES_VIA_FUNCTION();