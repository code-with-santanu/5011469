CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
    CURSOR savings_cursor IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
        FOR UPDATE;
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
BEGIN
    OPEN savings_cursor;
    LOOP
        FETCH savings_cursor INTO v_account_id, v_balance;
        EXIT WHEN savings_cursor%NOTFOUND;
        
        -- Apply 1% interest to the current balance
        UPDATE Accounts
        SET Balance = v_balance * 1.01,
            LastModified = SYSDATE
        WHERE AccountID = v_account_id;
    END LOOP;
    CLOSE savings_cursor;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred while processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/
