package tree;

import java.util.*;

public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // First leaf node found
                if (current.left == null && current.right == null) {
                    return depth;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            depth++;
        }

        return depth;
    }

    // Build tree using level order input
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

        System.out.println("Minimum Depth = " + minDepth(root));

        sc.close();
    }
}
