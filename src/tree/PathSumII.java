package tree;

import java.util.*;

public class PathSumII {

    public static void backtrack(
        TreeNode root,
        int targetSum,
        List<Integer> path,
        List<List<Integer>> ans
    ) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null &&
            root.right == null &&
            targetSum == root.val) {

            ans.add(new ArrayList<>(path));
        }

        backtrack(root.left, targetSum - root.val, path, ans);
        backtrack(root.right, targetSum - root.val, path, ans);

        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> pathSum(
        TreeNode root,
        int targetSum
    ) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(root, targetSum, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}
