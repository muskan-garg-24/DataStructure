package tree;

public class DeepestLeavesSum {

    static int maxDepth;
    static int sum;

    public static void dfs(TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            sum = root.val;
        } else if (depth == maxDepth) {
            sum += root.val;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public static int deepestLeavesSum(TreeNode root) {

        maxDepth = 0;
        sum = 0;

        dfs(root, 0);

        return sum;
    }

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
               / \   \
              4   5   6
             /         \
            7           8
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(deepestLeavesSum(root));
    }
}
