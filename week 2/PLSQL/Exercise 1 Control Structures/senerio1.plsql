DECLARE
    CURSOR customer_cursor IS
        SELECT c.CustomerID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM c.DOB) > 60;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id, v_interest_rate;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        UPDATE Loans
        SET InterestRate = v_interest_rate * 0.99
        WHERE CustomerID = v_customer_id;
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
END;
/
