package tree;

public class SymmetricTree {

    public static boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {

        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   2
             / \ / \
            3  4 4  3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
