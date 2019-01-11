import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : sortedListToBST.java
 * Time       : Create on 18-7-13
 * Location   : ../Home/JavaForLeeCode/sortedListToBST.java
 * Function   : LeeCode No.
 */
public class sortedListToBST {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static TreeNode sortedListToBSTResult(ListNode head) {
        if (head == null)
            return null;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode root = new TreeNode(list.get(list.size() / 2));
        int left = list.size() / 2 - 1;
        int right = list.size() / 2 + 1;
        create(0, left, list, root);
        create(right, list.size() - 1, list, root);
        return root;
    }

    private static void create(int begin, int end, List<Integer> list, TreeNode node) {
        if (begin > end)
            return;
        if (begin == end) {
            if (list.get(begin) > node.val)
                node.right = new TreeNode(list.get(begin));
            else
                node.left = new TreeNode(list.get(begin));
        } else {
            int mid = (begin + end + 1) / 2;
            if (node.val > list.get(mid)) {
                node.left = new TreeNode(list.get(mid));
                create(begin, mid - 1, list, node.left);
                create(mid + 1, end, list, node.left);
            } else {
                node.right = new TreeNode(list.get(mid));
                create(begin, mid - 1, list, node.right);
                create(mid + 1, end, list, node.right);
            }
        }
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            dfs(node.left, list);
            dfs(node.right, list);
        } else
            list.add(null);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-10);
//        node.next = new ListNode(-3);
//        node.next.next = new ListNode(0);
//        node.next.next.next = new ListNode(5);
//        node.next.next.next.next = new ListNode(9);
//        node.next.next.next.next.next = new ListNode(19);
        TreeNode tree = sortedListToBSTResult(node);
        List<Integer> l = new ArrayList<>();
        dfs(tree, l);
        System.out.println(l.toString());
    }


}
