import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : sortList.java
 * Time       : Create on 18-6-5
 * Location   : ../Home/JavaForLeeCode/sortList.java
 * Function   : LeeCode No.148
 */
public class sortList {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static  ListNode sortListResult(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode result = new ListNode(list.get(0));
        ListNode point = result;
        for (int i = 1 ; i < list.size() ; i ++ ) {
            result.next = new ListNode(list.get(i));
            result = result.next;
        }
        return point;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(1);
        node.next.next = new ListNode(7);
        node.next.next.next = new ListNode(13);
        node.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(-1);
        node.next.next.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next.next.next = new ListNode(12);

        ListNode temp = sortListResult(node);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
