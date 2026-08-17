package tree;

public class PseudoPalindromicPaths {

    public static int dfs(TreeNode root, int mask) {

        if (root == null) {
            return 0;
        }

        mask ^= (1 << root.val);

        if (root.left == null && root.right == null) {

            if ((mask & (mask - 1)) == 0) {
                return 1;
            }

            return 0;
        }

        return dfs(root.left, mask) + dfs(root.right, mask);
    }

    public static int pseudoPalindromicPaths(TreeNode root) {

        return dfs(root, 0);
    }

    public static void main(String[] args) {

        /*
                2
               / \
              3   1
             / \   \
            3   1   1
        */

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(3);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(1);

        System.out.println(pseudoPalindromicPaths(root));
    }
}
