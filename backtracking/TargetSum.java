package backtracking;

import java.util.*;

public class TargetSum {

    public static int backtrack(int index, int sum, int[] nums, int target) {

        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Choose '+'
        int add = backtrack(index + 1, sum + nums[index], nums, target);

        // Choose '-'
        int subtract = backtrack(index + 1, sum - nums[index], nums, target);

        return add + subtract;
    }

    public static int findTargetSumWays(int[] nums, int target) {

        return backtrack(0, 0, nums, target);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int ans = findTargetSumWays(nums, target);

        System.out.println(ans);
        sc.close();
    }
}