package recursion;

import java.util.Scanner;

public class RemoveConsecutiveDuplicate {

    // Recursive function to remove consecutive duplicates
    public static String removeDuplicates(String str) {

        // Base Case
        if (str.length() <= 1) {
            return str;
        }

        // If first two characters are same
        if (str.charAt(0) == str.charAt(1)) {
            return removeDuplicates(str.substring(1));
        }

        // Recursive Case
        return str.charAt(0) + removeDuplicates(str.substring(1));
    } 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.println("Output: " + removeDuplicates(str));

        sc.close();
    }
} 