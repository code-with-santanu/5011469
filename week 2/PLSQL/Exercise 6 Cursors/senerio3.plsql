DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;
    
    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN cur_loans%NOTFOUND;
        
        -- Example: Increase interest rate by 0.5%
        v_new_interest_rate := v_interest_rate + 0.5;
        
        -- Update the interest rate
        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id || ' - New
