public class MortgageCalculator {
    private final static int monthInYears = 12;
    private final static int percentage= 100;
    private float principal;
    private float rate;
    private int period;

    public MortgageCalculator(float principal, float rate, int period) {
        this.principal = principal;
        this.rate = rate;
        this.period = period;
    }

    public double[] getRemainingBalances(){
        var loanBalances = new double[getNumberOfPayments()];
        for (short month = 1; month <= loanBalances.length; month++)
            loanBalances[month -1] = calculateLoanBalance(month);
        return loanBalances;
    }

    public float calculateMortgage() {
        short numberOfPayments = (short) getNumberOfPayments();
        float newRate = getNewRate();
        float mortgage = (float) (principal * (newRate * (Math.pow((1 + newRate), numberOfPayments))) / (Math.pow((1 + newRate), numberOfPayments) - 1));
        return mortgage;
    }

    public float calculateLoanBalance(short numberOfPaymentsMade) {

        short numberOfPayments = (short) getNumberOfPayments();
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

}
