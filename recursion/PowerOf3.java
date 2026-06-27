package recursion;

import java.util.Scanner;

public class PowerOf3 {

    // Recursive function to check if n is a power of 3
    public static boolean isPowerOfThree(int n) {

        // Base Case 1
        if (n == 1) {
            return true;
        }

        // Base Case 2
        if (n <= 0 || n % 3 != 0) {
            return false;
        }

        // Recursive Case
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPowerOfThree(n)) {
            System.out.println("Yes, it is a power of 3.");
        } else {
            System.out.println("No, it is not a power of 3.");
        }

        sc.close();
    }
}