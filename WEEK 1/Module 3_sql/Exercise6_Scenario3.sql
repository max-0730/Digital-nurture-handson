SET SERVEROUTPUT ON;

DECLARE

    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID,
               InterestRate
        FROM Loans;

    v_LoanID Loans.LoanID%TYPE;
    v_InterestRate Loans.InterestRate%TYPE;

BEGIN

    OPEN UpdateLoanInterestRates;

    LOOP

        FETCH UpdateLoanInterestRates
        INTO v_LoanID,
             v_InterestRate;

        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = v_LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Interest Rate Updated for Loan '
            || v_LoanID
        );

    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

END;
/