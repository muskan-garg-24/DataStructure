package tree;

public class BinaryTreeTilt {

    static int tilt = 0;

    public static int subtreeSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = subtreeSum(root.left);
        int rightSum = subtreeSum(root.right);

        tilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + root.val;
    }

    public static int findTilt(TreeNode root) {

        tilt = 0;

        subtreeSum(root);

        return tilt;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(findTilt(root));
    }
}