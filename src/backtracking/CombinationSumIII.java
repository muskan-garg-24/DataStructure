package backtracking;

import java.util.*;

public class CombinationSumIII {

    public static void backtrack(int start, int k, int target, List<Integer> current, List<List<Integer>> ans) {

        if (target == 0 && current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || current.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {

            current.add(i);

            backtrack(i + 1, k, target - i, current, ans);

            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        List<List<Integer>> ans = combinationSum3(k, n);

        System.out.println(ans);
        sc.close();
    }
}