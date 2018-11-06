import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : isSubtree.java
 * Time       : Create on 18-6-26
 * Location   : ../Home/JavaForLeeCode/isSubtree.java
 * Function   : LeeCode No.572
 */
public class isSubtree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean isSubtreeResult(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        if (isSame(s, t))
            return true;
        return isSubtreeResult(s.left, t) || isSubtreeResult(s.right, t);
    }

    // DFS iterate and judge
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null )
            return false;
        if ( t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        System.out.println(isSubtreeResult(s, t));
    }
}
