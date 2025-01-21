//import java.util.Date;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
          int monthInYears = 12;
        int percentage= 100;
        //float price=  38.88F;
//        Date now = new Date();
        String message = "Principal:";
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        int principal = scanner.nextInt();

        String information = "Rate:";
        System.out.print(information);
        float rate = scanner.nextFloat();
        float newRate = (rate/percentage)/monthInYears;

        String info = "Period:";
        System.out.print(info);
        int period = scanner.nextInt();
        int numberOfPayments = period * monthInYears;


//        initial method for calculation
//        float upperBracket = (float)Math.pow((1+newRate),numberOfPayments)* newRate;
//        float lowerBracket = (float)Math.pow((1 + newRate),numberOfPayments)- 1;
//        float mortgage = principal *(upperBracket/lowerBracket);

        float mortgage = (float) (principal * (newRate*(Math.pow((1+newRate),numberOfPayments)))/(Math.pow((1+newRate),numberOfPayments)- 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("your mortgage is:" + mortgageFormatted);

      // initial method of printing
      //  System.out.println("you're principal is:" + principal + " and rate is:" + newRate + " and period is: "+period +" and your mortgage is:" + mortgage+"$");

    }
}