package tree;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public static void inorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        inorder(root.left, result);

        result.add(root.val);

        inorder(root.right, result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    public static TreeNode buildTree(Scanner sc) {

        int value = sc.nextInt();

        if (value == -1) {
            return null;
        }

        TreeNode root = new TreeNode(value);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            int left = sc.nextInt();
            if (left != -1) {
                current.left = new TreeNode(left);
                queue.offer(current.left);
            }

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

        List<Integer> ans = inorderTraversal(root);

        for (int num : ans) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}