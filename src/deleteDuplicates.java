/**
 * Author     : WindAsMe
 * File       : deleteDuplicates.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/deleteDuplicates.java
 * Function   : LeeCode No.83
 */
public class deleteDuplicates {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode deleteDuplicatesResult(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;
        else {
            ListNode firstPointer = head;
            ListNode secondPointer = head.next;
            while (secondPointer.next != null) {
                if (firstPointer.val == secondPointer.val) {
                    secondPointer = secondPointer.next;
                    firstPointer.next = secondPointer;
                } else {
                    firstPointer = firstPointer.next;
                    secondPointer = secondPointer.next;
                }
            }
            if (firstPointer.val == secondPointer.val)
                firstPointer.next = null;
            return head;
        }
    }
}
