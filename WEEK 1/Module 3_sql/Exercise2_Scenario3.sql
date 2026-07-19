SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_CustomerID NUMBER,
    p_Name VARCHAR2,
    p_DOB DATE,
    p_Balance NUMBER
)
IS
    v_Count NUMBER;
BEGIN

    SELECT COUNT(*)
    INTO v_Count
    FROM Customers
    WHERE CustomerID = p_CustomerID;

    IF v_Count > 0 THEN
        RAISE_APPLICATION_ERROR(
            -20003,
            'Customer ID already exists'
        );
    END IF;

    INSERT INTO Customers(
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified
    )
    VALUES(
        p_CustomerID,
        p_Name,
        p_DOB,
        p_Balance,
        SYSDATE
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer Added Successfully');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/