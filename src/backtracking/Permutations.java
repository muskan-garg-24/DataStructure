package backtracking;

import java.util.*;

public class Permutations {

    public static void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> ans) {

        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, visited, current, ans);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans = permute(nums);

        System.out.println(ans);
        sc.close();
    }
}