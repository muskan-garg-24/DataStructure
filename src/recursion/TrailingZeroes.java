package recursion;

import java.util.Scanner;

public class TrailingZeroes {

    public static int countTrailingZeroes(int n) {
        int count = 0;

        // Keep dividing by powers of 5
        while (n > 0) {
            n = n / 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int result = countTrailingZeroes(n);

        System.out.println("Trailing zeroes in " + n + "! = " + result);

        sc.close();
    }
}
