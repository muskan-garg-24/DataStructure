package tree;

public class FlipEquivalentBinaryTrees {

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null ||
            root1.val != root2.val) {
            return false;
        }

        boolean same =
            flipEquiv(root1.left, root2.left) &&
            flipEquiv(root1.right, root2.right);

        boolean flipped =
            flipEquiv(root1.left, root2.right) &&
            flipEquiv(root1.right, root2.left);

        return same || flipped;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);

        System.out.println(flipEquiv(root1, root2));
    }
}