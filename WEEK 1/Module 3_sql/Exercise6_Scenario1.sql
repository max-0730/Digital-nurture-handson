SET SERVEROUTPUT ON;

DECLARE

    CURSOR GenerateMonthlyStatements IS
        SELECT TransactionID,
               AccountID,
               Amount,
               TransactionType,
               TransactionDate
        FROM Transactions
        WHERE TRUNC(TransactionDate,'MM') =
              TRUNC(SYSDATE,'MM');

    v_TransactionID Transactions.TransactionID%TYPE;
    v_AccountID Transactions.AccountID%TYPE;
    v_Amount Transactions.Amount%TYPE;
    v_Type Transactions.TransactionType%TYPE;
    v_Date Transactions.TransactionDate%TYPE;

BEGIN

    OPEN GenerateMonthlyStatements;

    LOOP

        FETCH GenerateMonthlyStatements
        INTO v_TransactionID,
             v_AccountID,
             v_Amount,
             v_Type,
             v_Date;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Transaction ID: ' || v_TransactionID ||
            ' Account ID: ' || v_AccountID ||
            ' Amount: ' || v_Amount ||
            ' Type: ' || v_Type
        );

    END LOOP;

    CLOSE GenerateMonthlyStatements;

END;
/