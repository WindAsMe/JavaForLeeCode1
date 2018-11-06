import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : reverseBetween.java
 * Time       : Create on 18-7-24
 * Location   : ../Home/JavaForLeeCode/reverseBetween.java
 * Function   : LeeCode No.92
 */
public class reverseBetween {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    private static ListNode reverseBetweenResult(ListNode head, int m, int n) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int start = m - 1;
        int end = n - 1;
        while (start <= end) {
            int i = list.get(start);
            list.set(start, list.get(end));
            list.set(end, i);
            start++;
            end--;
        }
        node = head;
        for (Integer aList : list) {
            node.val = aList;
            node = node.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode n = reverseBetweenResult(node, 2, 3);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }
}
