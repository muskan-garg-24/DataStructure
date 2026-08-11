package tree;

public class CountGoodNodesInBinaryTree {

    public static int dfs(TreeNode root, int maxValue) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val >= maxValue) {
            count = 1;
        }

        maxValue = Math.max(maxValue, root.val);

        count += dfs(root.left, maxValue);
        count += dfs(root.right, maxValue);

        return count;
    }

    public static int goodNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }

    public static void main(String[] args) {

        /*
                  3
                 / \
                1   4
               /   / \
              3   1   5
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }
}