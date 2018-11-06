import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : deleteDuplicates1.java
 * Time       : Create on 18-7-23
 * Location   : ../Home/JavaForLeeCode/deleteDuplicates1.java
 * Function   : LeeCode No.82
 */
public class deleteDuplicates1 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                // System.out.println(list.toString() + " " + i);
                list.remove(i + 1);
                if (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) {
                    i--;
                } else {
                    list.remove(i);
                    i--;
                }
            }
        }
        if (list.size() == 0)
            return null;
        ListNode node1 = new ListNode(list.get(0));
        node = node1;
        for (int i = 1; i < list.size(); i++) {
            node1.next = new ListNode(list.get(i));
            node1 = node1.next;
        }
        return node;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(2);
        ListNode node1 = deleteDuplicates(node);
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
    }
}
