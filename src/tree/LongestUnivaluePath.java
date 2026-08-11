package tree;

public class LongestUnivaluePath {

    static int answer = 0;

    public static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0;
        int rightPath = 0;

        if (root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }

        answer = Math.max(answer, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }

    public static int longestUnivaluePath(TreeNode root) {

        answer = 0;

        dfs(root);

        return answer;
    }

    public static void main(String[] args) {

        /*
                5
               / \
              4   5
             / \   \
            1   1   5
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(5);

        System.out.println(longestUnivaluePath(root));
    }
}