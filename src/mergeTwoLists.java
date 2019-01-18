import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : mergeTwoLists.java
 * Time       : Create on 18-5-26
 * Location   : ../Home/JavaForLeeCode/mergeTwoLists.java
 * Function   : LeeCode No.21
 */
public class mergeTwoLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode mergeTwoListsResult(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        else {
            Stack<ListNode> stack = new Stack<>();
            while (true){
                if (l1 == null && l2 == null){
                    break;
                } else if (l1 == null){
                    stack.push(l2);
                    l2 = l2.next;
                } else if (l2 == null){
                    stack.push(l1);
                    l1 = l1.next;
                } else {
                    if (l1.val >= l2.val){
                        stack.push(l2);
                        l2 = l2.next;
                    } else {
                        stack.push(l1);
                        l1 = l1.next;
                    }
                }
            }
            ListNode node = stack.pop();
            while (!stack.empty()){
                ListNode temp = stack.pop();
                temp.next = node;
                node = temp;
            }
            return node;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next =new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next =new ListNode(4);
        ListNode node = mergeTwoListsResult(l1, l2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

}
