import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : preorder.java
 * Time       : Create on 18-7-18
 * Location   : ../Home/JavaForLeeCode/preorder.java
 * Function   : LeeCode No.589
 */
public class preorder {

    private static class Node {
        public int val;
        private List<Node> children;

        private Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private static List<Integer> preorderResult(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private static void dfs(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node a : root.children)
                    dfs(a, list);
            }
        }
    }


    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        List<Node> nodes = new ArrayList<>();
        Node node1 = new Node();
        Node node2 = new Node();
        node1.val = 2;
        node2.val = 3;
        nodes.add(node1);
        nodes.add(node2);
        node.children = nodes;

        List<Node> nodes1 = new ArrayList<>();
        Node node4 = new Node();
        Node node5 = new Node();
        node4.val = 5;
        node5.val = 6;
        nodes1.add(node4);
        nodes1.add(node5);
        nodes.get(0).children = nodes1;
        System.out.println(preorderResult(node).toString());
    }
}
