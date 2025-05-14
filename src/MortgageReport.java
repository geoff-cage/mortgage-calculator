import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private final NumberFormat currency;
    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (double loanBalance: calculator.getRemainingBalances())
            System.out.println(currency.format(loanBalance));

    }

    public void printMortgage() {
        float mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments:" + mortgageFormatted);
    }

}
