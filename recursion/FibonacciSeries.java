package recursion;

import java.util.Scanner;

public class FibonacciSeries {

    public static int fib(int n) {

        // Base Cases
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        // Recursive Case
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci Number = " + fib(n));

        sc.close();
    }
}