SET SERVEROUTPUT ON;

DECLARE

    CURSOR ApplyAnnualFee IS
        SELECT AccountID
        FROM Accounts;

    v_AccountID Accounts.AccountID%TYPE;

    v_Fee NUMBER := 100;

BEGIN

    OPEN ApplyAnnualFee;

    LOOP

        FETCH ApplyAnnualFee
        INTO v_AccountID;

        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_Fee
        WHERE AccountID = v_AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual Fee Applied to Account '
            || v_AccountID
        );

    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

END;
/