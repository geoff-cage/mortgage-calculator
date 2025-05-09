import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (short month = 1; month <= calculator.getPeriod() * MortgageCalculator.monthInYears; month++) {
            float loanBalance = calculator.calculateLoanBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(loanBalance));
        }
    }

    public void printMortgage() {
        float mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments:" + mortgageFormatted);
    }

}
