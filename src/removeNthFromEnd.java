/**
 * Author     : WindAsMe
 * File       : removeNthFromEnd.java
 * Time       : Create on 18-7-20
 * Location   : ../Home/JavaForLeeCode/removeNthFromEnd.java
 * Function   : LeeCode No.19
 */
public class removeNthFromEnd {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode removeNthFromEndResult(ListNode head, int n) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (n > len || n == 0)
            return head;
        if (n == len) {
            return head.next;
        }
        node = head;
        while (len > n + 1) {
            node = node.next;
            n++;
        }
        node.next = node.next.next;

//        node = head;
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        ListNode n = removeNthFromEndResult(node, 1);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }

    }
}
