package recursion;
/*
Problem

Given a numeric string, convert it into an integer using recursion.

Example
Input : "1234"
Output: 1234
*/
import java.util.Scanner;

public class StringToInteger {

    // Recursive function to convert string to integer
    public static int stringToInt(String str) {

        // Base Case
        if (str.length() == 1) {
            return str.charAt(0) - '0';
        }

        // Convert all digits except the last one
        int smallAns = stringToInt(str.substring(0, str.length() - 1));

        // Get the last digit
        int lastDigit = str.charAt(str.length() - 1) - '0';

        // Form the final number
        return smallAns * 10 + lastDigit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a numeric string: ");
        String str = sc.nextLine();

        System.out.println("Integer = " + stringToInt(str));

        sc.close();
    }
}