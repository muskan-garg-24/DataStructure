package backtracking;

import java.util.*;

public class CombinationSum {

    public static void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Pick current element (reuse allowed)
        current.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Not Pick current element
        backtrack(index + 1, candidates, target, current, ans);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        List<List<Integer>> ans = combinationSum(candidates, target);

        System.out.println(ans);
        sc.close();
    }
}