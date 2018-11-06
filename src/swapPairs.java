/**
 * Author     : WindAsMe
 * File       : swapPairs.java
 * Time       : Create on 18-7-19
 * Location   : ../Home/JavaForLeeCode/swapPairs.java
 * Function   : LeeCode No.24
 */
public class swapPairs {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Swap the value:
    private static ListNode swapPairsResult(ListNode head) {
        if (head == null ||  head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while (pre != null && next != null) {
            int temp = pre.val;
            pre.val = next.val;
            next.val = temp;
            pre = next.next;
            if (pre != null)
                next = pre.next;

        }
        return head;
    }

    // Swap the node
    private static ListNode swapPairsResult1(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode res = head.next;
        ListNode temp1 = head;
        ListNode temp2 = head;
        while(head.next.next != null){
            temp1 = head;
            temp2 = head.next.next;
            head.next.next = head;
            if(temp2.next == null){
                temp1.next = temp2;
                return res;
            }
            temp1.next = temp2.next;
            head = temp2;

        }
        temp1.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        //node.next = new ListNode(2);
        ListNode n = swapPairsResult(node);
        while (n != null) {
            System.out.print(n.val + ", " );
            n = n.next;
        }
    }
}
