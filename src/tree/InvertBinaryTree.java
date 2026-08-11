package tree;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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

        /*
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertTree(root);

        System.out.println("Preorder of Inverted Tree:");

        preorder(root);
    }
}
