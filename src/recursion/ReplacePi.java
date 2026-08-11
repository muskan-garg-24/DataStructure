package recursion;

/*
Problem

Replace every occurrence of "pi" in a string with "3.14" using recursion.

Example:

Input : xpix
Output: x3.14x
*/

import java.util.Scanner;

public class ReplacePi {

    // Recursive function to replace "pi" with "3.14"
    public static String replacePi(String str) {

        // Base Case
        if (str.length() <= 1) {
            return str;
        }

        // If first two characters are "pi"
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            return "3.14" + replacePi(str.substring(2));
        }

        // Recursive Case
        return str.charAt(0) + replacePi(str.substring(1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String str = sc.nextLine();

        System.out.println(replacePi(str));

        sc.close();
    }
}