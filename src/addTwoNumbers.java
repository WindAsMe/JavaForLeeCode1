import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : addTwoNumbers.java
 * Time       : Create on 18-6-18
 * Location   : ../Home/JavaForLeeCode/addTwoNumbers.java
 * Function   : LeeCode No.445
 */
public class addTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode addTwoNumbersResult(ListNode l1, ListNode l2) {
        Stack<Integer> sta1 = new Stack<>();
        Stack<Integer> sta2 = new Stack<>();
        Stack<Integer> sta = new Stack<>();
        while (l1 != null) {
            sta1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sta2.push(l2.val);
            l2 = l2.next;
        }
        int c = 0;
        while (!sta1.isEmpty() && !sta2.isEmpty()) {
            int sum = sta1.pop() + sta2.pop() + c;
            c = sum / 10;
            sum = sum % 10;
            sta.push(sum);
        }
        if (!sta2.isEmpty())
            sta1 = sta2;
        while (!sta1.isEmpty()) {
            int sum = sta1.pop() + c;
            c = sum / 10;
            sum = sum % 10;
            sta.push(sum);
        }
        if (c == 1)
            sta.push(1);
        ListNode dump = new ListNode(0);
        ListNode ret = dump;
        while (!sta.isEmpty()) {
            dump.next = new ListNode(sta.pop());
            dump = dump.next;
        }
        return ret.next;
    }
//    private static ListNode addTwoNumbersResult(ListNode l1, ListNode l2) {
//        Stack<ListNode> l1Stack = new Stack<>();
//        Stack<ListNode> l2Stack = new Stack<>();
//        l1Stack.push(l1);
//        l2Stack.push(l2);
//        while (l1.next != null) {
//            l1 = l1.next;
//            l1Stack.push(l1);
//        }
//        while (l2.next != null) {
//            l2 = l2.next;
//            l1Stack.push(l2);
//        }
//        int value = l1Stack.pop().val + l2Stack.pop().val;
//        ListNode last = new ListNode(value % 10);
//        int mark = value / 10;
//        ListNode point = new ListNode(0);
//        while (!l1Stack.empty() && !l2Stack.empty()) {
//            int temp = l1Stack.pop().val + l2Stack.pop().val + mark;
//            ListNode node = new ListNode(temp % 10);
//            node.next = last;
//            point.next = node;
//            mark = temp / 10;
//        }
//        if (l1Stack.empty() && !l2Stack.empty()) {
//            while (!l2Stack.empty()) {
//                int temp1 = l2Stack.pop().val + mark;
//                ListNode node = new ListNode(temp1 % 10);
//                node.next = last;
//                point.next = node;
//                mark = temp1 / 10;
//            }
//        }
//        if (!l1Stack.empty() && l2Stack.empty()) {
//            while (!l1Stack.empty()) {
//                int temp2 = l1Stack.pop().val + mark;
//                ListNode node = new ListNode(temp2 % 10);
//                node.next = last;
//                point.next = node;
//                mark = temp2 / 10;
//            }
//        }
//        return point.next;
//    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode node = addTwoNumbersResult(node1, node2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
