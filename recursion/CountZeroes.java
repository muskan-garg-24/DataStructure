package recursion;

/*
Given an integer N, count and return the number of zeroes that are present in the given integer using recursion.

For example:

Input is 0, then output should be 1
Input is 10204, then output should be 2
*/

import java.util.Scanner;

public class  CountZeroes {

    public static int countZeros(int input) {

        // Special case
        if (input == 0) {
            return 1;
        }

        // Base Case
        if (input < 10) {
            return 0;
        }

        // If last digit is 0
        if (input % 10 == 0) {
            return 1 + countZeros(input / 10);
        }

        // Recursive Case
        return countZeros(input / 10);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Number of zeros = " + countZeros(n));

        sc.close();
    }
}