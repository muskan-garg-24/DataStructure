package tree;

import java.util.*;

public class BinaryTreePaths {

    public static void dfs(TreeNode root, String path, List<String> ans) {

        if (root == null) {
            return;
        }

        path += root.val;

        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        path += "->";

        dfs(root.left, path, ans);
        dfs(root.right, path, ans);
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        dfs(root, "", ans);

        return ans;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
               \
                5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));
    }
}