package backtracking;
import java.util.*;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Include current element
        current.add(nums[index]);
        backtrack(index + 1, nums, current, ans);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current element
        backtrack(index + 1, nums, current, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Subsets sol = new Subsets();
        List<List<Integer>> result = sol.subsets(nums);

        System.out.println(result);
        sc.close();
    }
} 
