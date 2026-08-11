package recursion;

import java.util.Scanner;

public class SubsequenceWithSumK {

    public static boolean checkSubsequenceSum(int[] arr, int k) {
        return helper(arr, 0, k);
    }

    // Recursive function
    public static boolean helper(int[] arr, int index, int target) {

        // Base Case
        if (target == 0) {
            return true;
        }

        if (index == arr.length) {
            return false;
        }

        // Include current element
        if (helper(arr, index + 1, target - arr[index])) {
            return true;
        }

        // Exclude current element
        return helper(arr, index + 1, target);
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

        System.out.print("Enter target sum: ");
        int k = sc.nextInt();

        if (checkSubsequenceSum(arr, k)) {
            System.out.println("Subsequence Exists");
        } else {
            System.out.println("Subsequence Does Not Exist");
        }

        sc.close();
    }
}