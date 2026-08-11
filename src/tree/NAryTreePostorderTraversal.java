package tree;

import java.util.*;

class Node {

    int val;
    List<Node> children;

    Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class NAryTreePostorderTraversal {

    public static void dfs(Node node, List<Integer> ans) {

        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            dfs(child, ans);
        }

        ans.add(node.val);
    }

    public static List<Integer> postorder(Node root) {

        List<Integer> ans = new ArrayList<>();

        dfs(root, ans);

        return ans;
    }

    public static void main(String[] args) {

        /*
                1
             /  |  \
            3   2   4
           / \
          5   6
        */

        Node root = new Node(1);

        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        node3.children.add(node5);
        node3.children.add(node6);

        List<Integer> ans = postorder(root);

        System.out.println(ans);
    }
}
