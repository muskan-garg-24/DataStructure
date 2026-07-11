package backtracking;

import java.util.*;

class SubsetSum {

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        backtrack(0, 0, arr, ans);
        return ans;
    }

    private void backtrack(int index, int sum, int[] arr, ArrayList<Integer> ans) {

        if (index == arr.length) {
            ans.add(sum);
            return;
        }

        // Include current element
        backtrack(index + 1, sum + arr[index], arr, ans);

        // Exclude current element
        backtrack(index + 1, sum, arr, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SubsetSum sol = new SubsetSum();

        ArrayList<Integer> ans = sol.subsetSums(arr);

        System.out.println(ans);
        sc.close();
    }
} 