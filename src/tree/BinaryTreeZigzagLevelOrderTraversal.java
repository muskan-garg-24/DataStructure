package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                if (leftToRight) {
                    level.addLast(current.val);
                } else {
                    level.addFirst(current.val);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            ans.add(level);

            leftToRight = !leftToRight;
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                    3
                  /   \
                 9     20
                      /  \
                    15    7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = zigzagLevelOrder(root);

        System.out.println(ans);
    }
} 