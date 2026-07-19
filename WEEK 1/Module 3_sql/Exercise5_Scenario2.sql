CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN

    INSERT INTO AuditLog(
        TransactionID,
        AccountID,
        LogDate,
        Action
    )
    VALUES(
        :NEW.TransactionID,
        :NEW.AccountID,
        SYSDATE,
        'Transaction Inserted'
    );

END;
/