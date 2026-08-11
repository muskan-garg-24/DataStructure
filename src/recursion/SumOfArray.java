package recursion;

import java.util.Scanner;

public class SumOfArray {
    public static int arraySum(int[] arr) {
        return helper(arr, 0);
    }

    // Recursive helper function
    public static int helper(int[] arr, int index) {

        // Base Case
        if (index == arr.length) {
            return 0;
        }

        // Recursive Case
        return arr[index] + helper(arr, index + 1);
    }

     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Sum = " + arraySum(arr));

        sc.close();
    }
}

