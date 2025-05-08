public class MortgageCalculator {
    private float principal;
    private float rate;
    private int period;

    public MortgageCalculator(float principal, float rate, int period) {
        this.principal = principal;
        this.rate = rate;
        this.period = period;
    }

    public float calculateMortgage() {
        short numberOfPayments = (short) (period * Main.monthInYears);
        float newRate = (rate / Main.percentage) / Main.monthInYears;
        float mortgage = (float) (principal * (newRate * (Math.pow((1 + newRate), numberOfPayments))) / (Math.pow((1 + newRate), numberOfPayments) - 1));
        return mortgage;
    }

    public float calculateLoanBalance(short numberOfPaymentsMade) {

        short numberOfPayments = (short) (period * Main.monthInYears);
        float newRate = (rate / Main.percentage) / Main.monthInYears;
        float loanBalance = (float) (principal * (Math.pow(1 + newRate, numberOfPayments) - Math.pow(1 + newRate, numberOfPaymentsMade))
                / (Math.pow(1 + newRate, numberOfPayments) - 1));

        return loanBalance;
    }
}
