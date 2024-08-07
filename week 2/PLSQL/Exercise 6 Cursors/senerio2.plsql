DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;
    
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50;  -- Annual fee amount
BEGIN
    OPEN cur_accounts;
    LOOP
        FETCH cur_accounts INTO v_account_id, v_balance;
        EXIT WHEN cur_accounts%NOTFOUND;
        
        -- Deduct annual fee
        v_balance := v_balance - v_annual_fee;
        
        -- Update the account balance
        UPDATE Accounts
        SET Balance = v_balance
        WHERE AccountID = v_account_id;
        
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_account_id || ' - New Balance: ' || v_balance);
    END LOOP;
    CLOSE cur_accounts;
    COMMIT;
END;
/
