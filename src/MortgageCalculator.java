public class MortgageCalculator {
    public final static int monthInYears = 12;
    public final static int percentage= 100;
    private float principal;
    private float rate;
    private int period;

    public MortgageCalculator(float principal, float rate, int period) {
        this.principal = principal;
        this.rate = rate;
        this.period = period;
    }

    public float calculateMortgage() {
        short numberOfPayments = (short) getNumberOfPayments();
        float newRate = getNewRate();
        float mortgage = (float) (principal * (newRate * (Math.pow((1 + newRate), numberOfPayments))) / (Math.pow((1 + newRate), numberOfPayments) - 1));
        return mortgage;
    }

    public float calculateLoanBalance(short numberOfPaymentsMade) {

        short numberOfPayments = (short) (period * monthInYears);
        float newRate = getNewRate();
        float loanBalance = (float) (principal * (Math.pow(1 + newRate, numberOfPayments) - Math.pow(1 + newRate, numberOfPaymentsMade))
                / (Math.pow(1 + newRate, numberOfPayments) - 1));

        return loanBalance;
    }
    private int getNumberOfPayments() {
        return period * monthInYears;
    }

    private float getNewRate() {
        return (rate / percentage) / monthInYears;
    }

    //we create a getter for the period variable
    public int getPeriod() {
        return period;
    }
}
