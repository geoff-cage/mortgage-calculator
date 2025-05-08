public class MortgageCalculator {
    public static float calculateMortgage(float principal, float rate, int period) {
        short numberOfPayments = (short) (period * Main.monthInYears);
        float newRate = (rate / Main.percentage) / Main.monthInYears;
        float mortgage = (float) (principal * (newRate * (Math.pow((1 + newRate), numberOfPayments))) / (Math.pow((1 + newRate), numberOfPayments) - 1));
        return mortgage;
    }

    public static float calculateLoanBalance(float principal, float rate, int period, short numberOfPaymentsMade) {

        short numberOfPayments = (short) (period * Main.monthInYears);
        float newRate = (rate / Main.percentage) / Main.monthInYears;
        float loanBalance = (float) (principal * (Math.pow(1 + newRate, numberOfPayments) - Math.pow(1 + newRate, numberOfPaymentsMade))
                / (Math.pow(1 + newRate, numberOfPayments) - 1));

        return loanBalance;
    }
}
