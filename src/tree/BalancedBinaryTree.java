package tree;

import java.util.*;

public class BalancedBinaryTree {

    // Returns true if tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Returns height if balanced, otherwise -1
    public static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(root.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Build Tree (Level Order)
    public static TreeNode buildTree(Scanner sc) {

        System.out.println("Enter root value (-1 for null):");
        int value = sc.nextInt();

        if (value == -1) {
            return null;
        }

        TreeNode root = new TreeNode(value);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.println("Enter left child of " + current.val + " (-1 for null):");
            int left = sc.nextInt();

            if (left != -1) {
                current.left = new TreeNode(left);
                queue.offer(current.left);
            }

            System.out.println("Enter right child of " + current.val + " (-1 for null):");
            int right = sc.nextInt();

            if (right != -1) {
                current.right = new TreeNode(right);
                queue.offer(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TreeNode root = buildTree(sc);

        System.out.println(isBalanced(root));

        sc.close();
    }
}
