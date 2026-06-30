package recursion;

import java.util.Scanner;

public class CheckArrayIsSorted {

    public static boolean isSorted(int[] arr) {
        return helper(arr, 0);
    }

    // Recursive helper function
    public static boolean helper(int[] arr, int index) {

        // Base Case
        if (index == arr.length - 1) {
            return true;
        }

        // If array is not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Recursive Call
        return helper(arr, index + 1);
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

        if (isSorted(arr)) {
            System.out.println("Array is Sorted");
        } else {
            System.out.println("Array is Not Sorted");
        }

        sc.close();
    }
}
