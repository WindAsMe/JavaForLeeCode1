import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : postorder.java
 * Time       : Create on 18-8-20
 * Location   : ../Home/JavaForLeeCode/postorder.java
 * Function   : LeeCode No.590
 */
public class postorder {

    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // post order: left -> right -> mid
    private static List<Integer> postorderResult(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }


    private static void dfs(List<Integer> list, Node node) {
        if (node != null) {
            if (node.children != null) {
                for (Node temp : node.children)
                    dfs(list, temp);
            }
            list.add(node.val);
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        List<Node> list = new ArrayList<>();
        list.add(node5);
        list.add(node6);

        Node node3 = new Node(3, list);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        List<Node> list1 = new ArrayList<>();
        list.add(node3);
        list.add(node2);
        list.add(node4);

        Node node1 = new Node(1, list1);
        System.out.println(postorderResult(node1).toString());


    }

}
