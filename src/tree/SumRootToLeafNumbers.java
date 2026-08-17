package tree;

public class SumRootToLeafNumbers {

    public static int dfs(TreeNode root, int currentNumber) {

        if (root == null) {
            return 0;
        }

        currentNumber = currentNumber * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currentNumber;
        }

        return dfs(root.left, currentNumber) + dfs(root.right, currentNumber);
    }

    public static int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3

            Numbers = 12 + 13 = 25
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }
}
