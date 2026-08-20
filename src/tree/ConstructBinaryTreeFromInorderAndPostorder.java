package tree;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorder {

    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode build(int[] postorder,int left,int right) {

        if (left > right) {
            return null;
        }

        int value = postorder[postIndex--];

        TreeNode root = new TreeNode(value);

        int index = map.get(value);

        root.right = build(postorder, index + 1, right);
        root.left = build(postorder, left, index - 1);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;
        map.clear();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
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

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        preorder(root);
    }
}
