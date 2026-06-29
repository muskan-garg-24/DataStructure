package recursion;

import java.util.Scanner;
import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {

    // Recursive function
    public static int helper(int[] arr, int index) {

        // Base Case: Last element
        if (index == arr.length - 1) {
            int last = arr[index];
            arr[index] = -1;
            return last;
        }

        // Maximum element on the right
        int rightMax = helper(arr, index + 1);

        int current = arr[index];

        // Replace current element
        arr[index] = rightMax;

        // Return maximum till current index
        return Math.max(current, rightMax);
    }

    public static int[] replaceElements(int[] arr) {

        if (arr.length == 0)
            return arr;

        helper(arr, 0);
        return arr;
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

        replaceElements(arr);

        System.out.println("Modified Array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}