package tree;

public class DiameterOfBinaryTree {

    static int diameter = 0;

    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {

        diameter = 0;

        height(root);

        return diameter;
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \
               4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}