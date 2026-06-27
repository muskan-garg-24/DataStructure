package recursion;

import java.util.Scanner;

public class SumOfDigits {

    // Recursive function to calculate sum of digits
    public static int sumOfDigits(int n) {

        // Base Case
        if (n == 0) {
            return 0;
        }

        // Recursive Case
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Handle negative numbers
        n = Math.abs(n);

        System.out.println("Sum of Digits = " + sumOfDigits(n));

        sc.close();
    }
}
