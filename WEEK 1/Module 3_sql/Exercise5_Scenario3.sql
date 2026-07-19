CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN

    IF :NEW.TransactionType = 'Deposit'
       AND :NEW.Amount <= 0 THEN

       RAISE_APPLICATION_ERROR(
           -20005,
           'Deposit amount must be positive'
       );

    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN

       SELECT Balance
       INTO v_Balance
       FROM Accounts
       WHERE AccountID = :NEW.AccountID;

       IF :NEW.Amount > v_Balance THEN

          RAISE_APPLICATION_ERROR(
              -20006,
              'Withdrawal exceeds account balance'
          );

       END IF;

    END IF;

END;
/