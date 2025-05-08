public class Main {
    final static int monthInYears = 12;
    final static int percentage= 100;

    public static void main(String[] args) {
        float principal = (float) Console.readNumber("Principal:",1000,1000000);
        float rate = (float) Console.readNumber("Annual Rate:", 1, 30);
        int period= (int) Console.readNumber("period:", 1,30);

        MortgageReport.printMortgage(principal, rate, period);
        MortgageReport.printPaymentSchedule(period, principal, rate);
    }

}