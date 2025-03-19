import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    static int monthInYears = 12;
    static int percentage= 100;
    public static void main(String[] args) {
        float principal = (float) readNumber("Principal:",1000,1000000);
        float rate = (float) readNumber("Annual Rate:", 1, 30);
        int period= (int) readNumber("period:", 1,30);

        printMortgage(principal, rate, period);
        printPaymentSchedule(period, principal, rate);
    }

    private static void printMortgage(float principal, float rate, int period) {
        float mortgage= calculateMortgage(principal, rate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments:" + mortgageFormatted);
    }

    private static void printPaymentSchedule(int period, float principal, float rate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("--------");
        for (short month = 1; month <= period * monthInYears; month++){
            float loanBalance = calculateLoanBalance(principal, rate, period,month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(loanBalance));
        }
    }

    public static double readNumber(String prompt,double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value >=min && value<=max)
                break;
            System.out.println("Enter value between "+ min + " and" + max);
        }

        return value;
    }
    public static float calculateMortgage(float principal,float rate, int period){
        short numberOfPayments = (short) (period * monthInYears);
        float newRate = (rate / percentage) / monthInYears;
        float mortgage = (float) (principal * (newRate*(Math.pow((1+newRate),numberOfPayments)))/(Math.pow((1+newRate),numberOfPayments)- 1));
        return mortgage;
    }

    public static float calculateLoanBalance(float principal,float rate,int period,short numberOfPaymentsMade){

        short numberOfPayments = (short) (period * monthInYears);
        float newRate = (rate / percentage) / monthInYears;
        float loanBalance =(float) (principal * (Math.pow(1+newRate, numberOfPayments)- Math.pow(1+newRate,numberOfPaymentsMade))
                /(Math.pow(1+newRate,numberOfPayments)-1));

        return loanBalance;
    }

}