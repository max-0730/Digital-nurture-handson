SET SERVEROUTPUT ON;

BEGIN
   FOR cust IN (
      SELECT CustomerID
      FROM Customers
      WHERE FLOOR(MONTHS_BETWEEN(SYSDATE,DOB)/12) > 60
   )
   LOOP

      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = cust.CustomerID;

      DBMS_OUTPUT.PUT_LINE(
         'Discount applied for Customer ID: ' ||
         cust.CustomerID
      );

   END LOOP;

   COMMIT;
END;
/

INSERT INTO Loans
(LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES
(1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE,60));

COMMIT;
SELECT LoanID,
       CustomerID,
       InterestRate
FROM Loans;
SELECT * FROM Loans;