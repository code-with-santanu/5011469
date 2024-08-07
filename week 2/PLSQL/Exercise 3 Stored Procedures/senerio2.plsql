CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update salary by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100),
        LastModified = SYSDATE
    WHERE Department = p_department;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Bonus applied to employees in department: ' || p_department);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred while updating employee bonus: ' || SQLERRM);
END UpdateEmployeeBonus;
/
