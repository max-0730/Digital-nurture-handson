SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount NUMBER,
    p_InterestRate NUMBER,
    p_Years NUMBER
)
RETURN NUMBER
IS
    v_MonthlyRate NUMBER;
    v_Months NUMBER;
    v_EMI NUMBER;
BEGIN

    v_MonthlyRate := p_InterestRate / (12 * 100);

    v_Months := p_Years * 12;

    v_EMI := (p_LoanAmount * v_MonthlyRate *
             POWER(1 + v_MonthlyRate, v_Months))
             /
             (POWER(1 + v_MonthlyRate, v_Months) - 1);

    RETURN ROUND(v_EMI, 2);

END;
/