CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN
    -- Get the current balance of the account
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID FOR UPDATE;
    
    -- Check if the transaction is a withdrawal and if it exceeds the current balance
    IF :NEW.TransactionType = 'Withdrawal' THEN
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        -- Check if the deposit amount is positive
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    ELSE
        -- Handle other transaction types if necessary
        RAISE_APPLICATION_ERROR(-20003, 'Invalid transaction type.');
    END IF;
    
    -- Update the balance in the Accounts table
    IF :NEW.TransactionType = 'Deposit' THEN
        UPDATE Accounts SET Balance = v_balance + :NEW.Amount WHERE AccountID = :NEW.AccountID;
    ELSIF :NEW.TransactionType = 'Withdrawal' THEN
        UPDATE Accounts SET Balance = v_balance - :NEW.Amount WHERE AccountID = :NEW.AccountID;
    END IF;
END CheckTransactionRules;
/
