package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class MinMaxInArray {

    public static ArrayList<Integer> getMinMax(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        int[] result = helper(arr, 0);

        ans.add(result[0]); // Minimum
        ans.add(result[1]); // Maximum

        return ans;
    }

    // Recursive function
    private static int[] helper(int[] arr, int index) {

        // Base Case
        if (index == arr.length - 1) {
            return new int[]{arr[index], arr[index]};
        }

        // Recursive Call
        int[] smallAns = helper(arr, index + 1);

        // Update minimum
        smallAns[0] = Math.min(arr[index], smallAns[0]);

        // Update maximum
        smallAns[1] = Math.max(arr[index], smallAns[1]);

        return smallAns;
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

        ArrayList<Integer> ans = getMinMax(arr);

        System.out.println("Minimum = " + ans.get(0));
        System.out.println("Maximum = " + ans.get(1));

        sc.close();
    }
}