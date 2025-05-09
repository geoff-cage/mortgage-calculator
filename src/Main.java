public class Main {

    public static void main(String[] args) {
        float principal = (float) Console.readNumber("Principal:",1000,1000000);
        float rate = (float) Console.readNumber("Annual Rate:", 1, 30);
        int period= (int) Console.readNumber("period:", 1,30);

        var calculator = new MortgageCalculator(principal,rate,period);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}