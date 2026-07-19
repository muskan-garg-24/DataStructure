package backtracking;

import java.util.*;

public class SumOfAllSubsetXORTotals {

    public static int backtrack(int index, int xor, int[] nums) {

        if (index == nums.length) {
            return xor;
        }

        // Include current element
        int include = backtrack(index + 1, xor ^ nums[index], nums);

        // Exclude current element
        int exclude = backtrack(index + 1, xor, nums);

        return include + exclude;
    }

    public static int subsetXORSum(int[] nums) {

        return backtrack(0, 0, nums);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(subsetXORSum(nums));
        sc.close();
    }
}