DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000;
    
    v_customer_id Customers.CustomerID%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id;
        EXIT WHEN customer_cursor%NOTFOUND;
        
        UPDATE Customers
        SET LastModified = SYSDATE  -- Example of setting a flag, assuming LastModified can serve this purpose
        WHERE CustomerID = v_customer_id;
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
END;
/
