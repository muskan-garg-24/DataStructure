package tree;

public class MaximumDifferenceBetweenNodeAndAncestor {

    public static int dfs(TreeNode root, int min, int max) {

        if (root == null) {
            return max - min;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int left = dfs(root.left, min, max);
        int right = dfs(root.right, min, max);

        return Math.max(left, right);
    }

    public static int maxAncestorDiff(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return dfs(root, root.val, root.val);
    }

    public static void main(String[] args) {

        /*
                    8
                  /   \
                 3     10
                / \      \
               1   6      14
                  / \     /
                 4   7   13
        */

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(maxAncestorDiff(root));
    }
}