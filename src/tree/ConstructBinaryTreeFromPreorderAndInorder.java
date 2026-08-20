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

public class ConstructBinaryTreeFromPreorderAndInorder {

    static int preIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int value = preorder[preIndex++];

        TreeNode root = new TreeNode(value);

        int index = map.get(value);

        root.left = build(preorder, left, index - 1);
        root.right = build(preorder, index + 1, right);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        preIndex = 0;
        map.clear();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        preorder(root);
    }
}
