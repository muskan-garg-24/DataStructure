package tree;

public class ValidateBinarySearchTree {

    public static boolean validate(
        TreeNode root,
        long min,
        long max
    ) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validate(root.left, min, root.val)
            && validate(root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   7
             / \   \
            2   4   8
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(8);

        System.out.println(isValidBST(root));
    }
}
