package recursion;

import java.util.Scanner;

public class ReverseString {

    // Recursive function
    public static void reverse(char[] s, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Swap characters
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Recursive Call
        reverse(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] arr = str.toCharArray();

        reverse(arr, 0, arr.length - 1);

        System.out.println("Reversed String: " + new String(arr));

        sc.close();
    }
}