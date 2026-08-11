package backtracking;

import java.util.*;

public class CombinationSumII {

    public static void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            backtrack(i + 1, candidates, target - candidates[i], current, ans);

            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

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

        List<List<Integer>> ans = combinationSum2(candidates, target);

        System.out.println(ans);
        sc.close();
    }
}