//import java.util.Date;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
          int monthInYears = 12;
        int percentage= 100;
        int principal = 0;
        float rate =0;
        int period =0;
        float newRate = 0;
        int numberOfPayments=0;
        String message = "Principal (100,000 - 1,000,000,0000):";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print(message);
            principal = scanner.nextInt();
            if(principal >=100000 && principal<=1000000)
                break;
            System.out.println("Enter value between 100,000 and 1,000,000");
        }

        String information = "Rate:";
        while (true) {
            System.out.print(information);
             rate = scanner.nextFloat();
             if (rate >=1 && rate<=30) {
                 newRate = (rate / percentage) / monthInYears;
                 break;
             }
            System.out.println("Enter value greater than or equal to 1 and less than or equal to 30");
        }


        String info = "Period:";
        while(true) {
            System.out.print(info);
            period = scanner.nextInt();
            if(period>0 && period<=30) {
                numberOfPayments = period * monthInYears;
                break;
            }
            System.out.println("Enter value greater than 0 and less than or equal 30");
        }



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