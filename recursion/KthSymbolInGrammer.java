package recursion;

import java.util.Scanner;

public class KthSymbolInGrammer {

    // Returns the kth symbol in nth row
    public static int kthGrammar(int n, int k) {

        // Base Case
        if (n == 1) {
            return 0;
        }

        int mid = 1 << (n - 2); // Half of the current row length

        // If k lies in the left half
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }

        // If k lies in the right half
        return 1 - kthGrammar(n - 1, k - mid);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println(kthGrammar(n, k));

        sc.close();
    }
}