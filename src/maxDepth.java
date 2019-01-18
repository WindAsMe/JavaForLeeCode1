import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : maxDepth.java
 * Time       : Create on 18-7-18
 * Location   : ../Home/JavaForLeeCode/maxDepth.java
 * Function   : LeeCode No.559
 */
public class maxDepth {

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

    private static int maxDepthResult(Node root) {
        // max[0]: cur max depth
        int[] max = new int[1];
        depth(root, max, 0);
        return max[0];
    }

    private static void depth(Node node, int[] max, int cur) {
        // System.out.println("max: " + max[0] + " cur: " + cur);
        if (node == null)
            max[0] = Math.max(max[0], cur);
        else {
            if (node.children != null) {
                cur++;
                for (Node tiny : node.children)
                    depth(tiny, max, cur);
            } else
                max[0] = Math.max(max[0], cur);
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
        System.out.println(maxDepthResult(node));
    }
}