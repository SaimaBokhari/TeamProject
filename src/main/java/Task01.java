import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Task01 {
        public static void main(String[] args) {
        /*
        6.[Coding] In any programming language, write a function which checks if a given number is fullfilling all 3 conditions at the same time:
    it is Fibonacci number, odd number and prime number. Consider reading the number from user input.
        */

            // I USED INTELLIJ AS IDE AND I USED JAVA AS PROGRAMMING LANGUAGE AND THIS METHOD BELONG TO ME
            // IF YOU WANT I CAN EXPLAIN EVERY PART OF THIS METHOD I WROTE THIS METHOD IN 30 MINUTES

            // method call
            checkNumberGivenByUser();
        }


        public static void checkNumberGivenByUser() {
            int num = 0;
            int counter = 0;

            // To get number from user
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter a number to check if it is fullfilling all three conditions at the same time: Is it fibonacci number, odd number and prime number)");
            num = scan.nextInt();

            // boolean variables to check 3 different conditions
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;

            // To check the number is odd or not
            if (num % 2 == 1) {
                flag1 = true;
            }

            // To check the number is prime or not
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    counter++;
                }
            }

            if (counter == 2) {
                flag2 = true;
            }

            // To check number is fibonacci or not
            List<Integer> fibonacciList = new ArrayList<>();
            int fibo1 = 1;
            int fibo2 = 1;
            fibonacciList.add(fibo1);
            fibonacciList.add(fibo2);
            int fibonacci = 0;
            for (int j = 1; j <= num; j++) {
                fibonacci = fibo1 + fibo2;
                fibo1 = fibo2;
                fibo2 = fibonacci;
                if (!fibonacciList.contains(fibonacci)) {
                    fibonacciList.add(fibonacci);
                }
            }

            if (fibonacciList.contains(num)) {
                flag3 = true;
            }


            // To check all conditions
            if (flag1 == true && flag2 == true && flag3 == true) {
                System.out.println(num + " is fullfilling all 3 conditions at the same time: It is Fibonacci number, odd number and prime number");
            } else {
                System.out.println(num + " is not fullfilling all 3 conditions at the same time");
        }
    }
}
