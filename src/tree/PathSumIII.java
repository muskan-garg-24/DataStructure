package tree;

public class PathSumIII {

    static int count = 0;

    public static int pathSum(TreeNode root, int targetSum) {

        count = 0;

        dfs(root, targetSum);

        return count;
    }

    private static void dfs(TreeNode root, long targetSum) {

        if (root == null) {
            return;
        }

        findPaths(root, targetSum, 0);

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }

    private static void findPaths(
        TreeNode root,
        long targetSum,
        long currentSum
    ) {

        if (root == null) {
            return;
        }

        currentSum += root.val;

        if (currentSum == targetSum) {
            count++;
        }

        findPaths(root.left, targetSum, currentSum);
        findPaths(root.right, targetSum, currentSum);
    }

    public static void main(String[] args) {

        /*
                  10
                 /  \
                5   -3
               / \    \
              3   2    11
             / \   \
            3  -2   1

            Target = 8
        */

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(11);

        System.out.println(pathSum(root, 8));
    }
}
