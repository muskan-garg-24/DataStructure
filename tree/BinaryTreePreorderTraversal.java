package tree;

import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreePreorderTraversal {

    public static void preorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        result.add(root.val);

        preorder(root.left, result);

        preorder(root.right, result);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

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

        List<Integer> ans = preorderTraversal(root);

        for (int num : ans) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
