import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private static MortgageCalculator calculator;

    public static void printMortgage(float principal, float rate, int period) {
        // we create an object (calculator) since the calculateMortgage method is no longer static hence cant be referred by a static method
        calculator = new MortgageCalculator(principal,rate,period);
        float mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments:" + mortgageFormatted);
    }

    public static void printPaymentSchedule(int period, float principal, float rate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (short month = 1; month <= period * Main.monthInYears; month++) {
            float loanBalance = calculator.calculateLoanBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(loanBalance));
        }
    }
}
