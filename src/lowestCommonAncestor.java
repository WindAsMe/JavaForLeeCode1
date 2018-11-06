/**
 * Author     : WindAsMe
 * File       : lowestCommonAncestor.java
 * Time       : Create on 18-7-16
 * Location   : ../Home/JavaForLeeCode/lowestCommonAncestor.java
 * Function   : LeeCode No.235
 */
public class lowestCommonAncestor {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 1. root.val == p.val || root.val == q.val
    // 2. root.val > p.val && root.val > q.val: find in left
    // 3. root.val < p.val && root.val < q.val: find in right
    // 4. return root
    private static TreeNode lowestCommonAncestorResult(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorResult(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorResult(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}

