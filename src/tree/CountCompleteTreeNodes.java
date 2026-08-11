package tree;

public class CountCompleteTreeNodes {

    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // Perfect Binary Tree
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int getLeftHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public static int getRightHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.right;
        }

        return height;
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \   /
               4   5 6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }
}