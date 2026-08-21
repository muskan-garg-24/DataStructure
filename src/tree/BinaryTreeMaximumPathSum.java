package tree;

public class BinaryTreeMaximumPathSum {

    static int maxSum;

    public static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        int currentPath = root.val + left + right;

        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(left, right);
    }

    public static int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        dfs(root);

        return maxSum;
    }

    public static void main(String[] args) {

        /*
                -10
                /  \
               9   20
                  /  \
                 15   7

            Maximum Path = 15 -> 20 -> 7
            Sum = 42
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}
