package backtracking;

import java.util.*;

class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>(), ans);

        return ans;
    }

    private static void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> ans) {

        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, visited, current, ans);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans = permuteUnique(nums);

        System.out.println(ans);
        sc.close();
    }
}