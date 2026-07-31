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

public class BinaryTreePostorderTraversal {

    public static void postorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }
        postorder(root.left, result);

        postorder(root.right, result);

        result.add(root.val);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        postorder(root, result);

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

        List<Integer> ans = postorderTraversal(root);

        for (int num : ans) {
            System.out.print(num + " ");
        }

        sc.close();
    }
} 
