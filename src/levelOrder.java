
import java.util.*;

/**
 * Author     : WindAsMe
 * File       : levelOrder.java
 * Time       : Create on 18-7-16
 * Location   : ../Home/JavaForLeeCode/levelOrder.java
 * Function   : LeeCode No.429
 */
public class levelOrder {
    private static class Node {
        private int val;
        private List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private static List<List<Integer>> levelOrderResult(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        List<Node> nodes1 = new ArrayList<>();
        List<Node> nodes2 = new ArrayList<>();
        nodes1.add(root);
        while (nodes1.size() != 0 || nodes2.size() != 0) {
            if (nodes1.size() != 0) {
                List<Integer> list = new ArrayList<>();
                for (Node node : nodes1) {
                    System.out.println("nodes1: " + node.val);
                    list.add(node.val);
                    if (node.children != null)
                        nodes2.addAll(node.children);
                }
                nodes1.clear();
                lists.add(list);
            }
            if (nodes2.size() != 0) {
                List<Integer> list = new ArrayList<>();
                for (Node node : nodes2) {
                    System.out.println("nodes2: " + node.val);
                    list.add(node.val);
                    if (node.children != null)
                        nodes1.addAll(node.children);
                }
                nodes2.clear();
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        List<Node> nodes = new ArrayList<>();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        node1.val = 3;
        node2.val = 2;
        node3.val = 4;
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        node.children = nodes;

        List<Node> nodes1 = new ArrayList<>();
        Node node4 = new Node();
        Node node5 = new Node();
        node4.val = 5;
        node5.val = 6;
        nodes1.add(node4);
        nodes1.add(node5);
        nodes.get(0).children = nodes1;
        List<List<Integer>> lists = levelOrderResult(node);
        for (List<Integer> list : lists)
            System.out.println(list.toString());
    }

}
