package recursion;

import java.util.Scanner;

public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {

        // Base Case
        if (n == 1) {
            return true;
        }

        // Invalid Cases
        if (n <= 0 || n % 2 != 0) {
            return false;
        }

        // Recursive Call
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPowerOfTwo(n)) {
            System.out.println("Power of Two");
        } else {
            System.out.println("Not a Power of Two");
        }

        sc.close();
    }
}