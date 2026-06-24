UPDATE Customers
SET IsVIP = 'TRUE'
WHERE CustomerID = 1;
COMMIT;
SELECT CustomerID, IsVIP
FROM Customers
WHERE CustomerID = 1;
SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;
SET SERVEROUTPUT ON;

BEGIN
   UPDATE Customers
   SET IsVIP = 'TRUE'
   WHERE Balance > 10000;

   DBMS_OUTPUT.PUT_LINE('VIP status updated.');

   COMMIT;
END;
/
SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;
