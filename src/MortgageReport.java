import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    public static void printMortgage(float principal, float rate, int period) {
        float mortgage = MortgageCalculator.calculateMortgage(principal, rate, period);
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
            float loanBalance = MortgageCalculator.calculateLoanBalance(principal, rate, period, month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(loanBalance));
        }
    }
}
