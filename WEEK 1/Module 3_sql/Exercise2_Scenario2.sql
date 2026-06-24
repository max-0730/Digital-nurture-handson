SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmployeeID NUMBER,
    p_Percentage NUMBER
)
IS
    v_Count NUMBER;
BEGIN

    SELECT COUNT(*)
    INTO v_Count
    FROM Employees
    WHERE EmployeeID = p_EmployeeID;

    IF v_Count = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'Employee ID does not exist'
        );
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
   UpdateSalary(1,10);
END;
/

SELECT EmployeeID,
       Name,
       Salary
FROM Employees;

