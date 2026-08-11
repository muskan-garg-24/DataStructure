package recursion;
/*
Problem

Given a string, insert a '*' between every pair of identical adjacent characters using recursion.

Examples
Input : hello
Output: hel*lo
*/
import java.util.Scanner;

public class PairStar {

    // Recursive function to insert '*' between identical adjacent characters
    public static String pairStar(String str) {

        // Base Case
        if (str.length() <= 1) {
            return str;
        }

        // If first two characters are the same
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + pairStar(str.substring(1));
        }

        // Recursive Case
        return str.charAt(0) + pairStar(str.substring(1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Output: " + pairStar(str));

        sc.close();
    }
}
