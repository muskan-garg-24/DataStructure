package tree;

public class KthSmallestElementInBST {

    static int count;
    static int answer;

    public static void inorder(TreeNode root, int k) {

        if (root == null || count >= k) {
            return;
        }

        inorder(root.left, k);

        count++;

        if (count == k) {
            answer = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public static int kthSmallest(TreeNode root, int k) {

        count = 0;
        answer = 0;

        inorder(root, k);

        return answer;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              1   4
               \
                2
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root, 1));
    }
}
