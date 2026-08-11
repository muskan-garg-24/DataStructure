package tree;

import java.util.*;

public class AverageOfLevelsInBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            long sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                sum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            ans.add((double) sum / size);
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                    3
                  /   \
                 9     20
                      /  \
                     15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> ans = averageOfLevels(root);

        System.out.println(ans);
    }
}
