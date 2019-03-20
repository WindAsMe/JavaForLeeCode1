import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : insertionSortList.java
 * Time       : Create on 18-7-13
 * Location   : ../Home/JavaForLeeCode/insertionSortList.java
 * Function   : LeeCode No.147
 */
public class insertionSortList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode insertionSortListResult1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev, temp;
        while (cur.next != null) {
            if (cur.val <= cur.next.val)
                cur = cur.next;
            else {
                temp = cur.next;
                cur.next = temp.next;
                prev = dummy;
                while (prev.next.val <= temp.val)
                    prev = prev.next;
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }

    // Trans to List then sort
    private static ListNode insertionSortListResult(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        node = head;
        int i = 0;
        while (i < list.size()) {
            node.val = list.get(i);
            i++;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);

        ListNode ans = insertionSortListResult(node);
        while (ans != null) {
            System.out.println(ans.val + " ");
            ans = ans.next;
        }
    }
}
