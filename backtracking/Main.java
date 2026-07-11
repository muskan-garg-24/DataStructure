package backtracking;

import java.util.*;

class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            backtrack(i + 1, nums, current, ans);

            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SubsetsII sol = new SubsetsII();

        List<List<Integer>> ans = sol.subsetsWithDup(nums);

        System.out.println(ans);
        sc.close();
    }
}