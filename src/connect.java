
/**
 * Author     : WindAsMe
 * File       : connect.java
 * Time       : Create on 18-7-14
 * Location   : ../Home/JavaForLeeCode/connect.java
 * Function   : LeeCode No.116
 */
public class connect {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    private static void connectResult(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while(level_start != null){
            TreeLinkNode cur = level_start;
            while(cur != null){
                if(cur.left != null)
                    cur.left.next = cur.right;
                if(cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }

    private static void dfs(TreeLinkNode node) {
        if (node != null) {
            System.out.println(node.next);
            dfs(node.left);
            dfs(node.right);
        }
    }


    public static void main(String[] args) {
        TreeLinkNode s = new TreeLinkNode(1);
        s.left = new TreeLinkNode(2);
        s.left.left = new TreeLinkNode(4);
        s.left.right = new TreeLinkNode(5);

        s.right = new TreeLinkNode(3);
        s.right.left = new TreeLinkNode(6);
        s.right.right = new TreeLinkNode(7);
        connectResult(s);
    }
}
