SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN

   UPDATE Accounts
   SET Balance = Balance + (Balance * 0.01)
   WHERE UPPER(AccountType) = 'SAVINGS';

   COMMIT;

   DBMS_OUTPUT.PUT_LINE(
      'Monthly Interest Applied Successfully'
   );

EXCEPTION

   WHEN OTHERS THEN

      ROLLBACK;

      DBMS_OUTPUT.PUT_LINE(
         'Error: ' || SQLERRM
      );

END;
/