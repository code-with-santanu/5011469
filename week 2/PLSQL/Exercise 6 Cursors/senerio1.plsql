DECLARE
    CURSOR cur_transactions IS
        SELECT t.AccountID, t.TransactionDate, t.Amount, t.TransactionType, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
    
    v_account_id Accounts.AccountID%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
    v_customer_name Customers.Name%TYPE;
BEGIN
    OPEN cur_transactions;
    LOOP
        FETCH cur_transactions INTO v_account_id, v_transaction_date, v_amount, v_transaction_type, v_customer_name;
        EXIT WHEN cur_transactions%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_customer_name);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || TO_CHAR(v_transaction_date, 'YYYY-MM-DD'));
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || v_transaction_type);
        DBMS_OUTPUT.PUT_LINE('------------------------------');
    END LOOP;
    CLOSE cur_transactions;
END;
/
