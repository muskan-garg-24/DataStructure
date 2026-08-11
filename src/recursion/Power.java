package recursion;
/*
Problem

Given two integers x and n, find xⁿ using recursion.

Examples
Input:
x = 2, n = 5

Output:
32
*/
import java.util.Scanner;

public class Power {

    // Recursive function to calculate x^n
    public static long power(int x, int n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        // Recursive Case
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        int x = sc.nextInt();

        System.out.print("Enter exponent: ");
        int n = sc.nextInt();

        System.out.println("Answer = " + power(x, n));

        sc.close();
    }
}