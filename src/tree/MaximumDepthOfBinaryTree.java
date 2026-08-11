package tree; 

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);

        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        /*
                    3
                  /   \
                 9     20
                      /  \
                     15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }
}