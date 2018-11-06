/**
 * Author     : WindAsMe
 * File       : trimBST.java
 * Time       : Create on 18-7-2
 * Location   : ../Home/JavaForLeeCode/trimBST.java
 * Function   : LeeCode No.669
 */
public class trimBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // More efficient
    private static TreeNode trimBSTResult1(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val < L)
            return trimBSTResult1(root.right, L, R);
        if (root.val > R)
            return trimBSTResult1(root.left, L, R);
        root.left = trimBSTResult1(root.left, L, R);
        root.right = trimBSTResult1(root.right, L, R);
        return root;
    }


    private static TreeNode trimBSTResult(TreeNode root, int L, int R) {
        if (root.val > R) {
            return trimBSTResult(root.left, L, R);
        } else if (root.val < L) {
            return trimBSTResult(root.right, L, R);
        } else {
            // root is in (L, R)
            dfs(root, root.left, true, L, R);
            dfs(root, root.right, false, L, R);
            return root;
        }
    }

    // flag indicate the current node
    // left or right son of father
    // true: left
    // false: right
    private static void dfs(TreeNode before, TreeNode node, boolean flag, int L, int R) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                if (flag) {
                    before.left = node;
                } else {
                    before.right = node;
                }
                dfs(node, node.left, true, L, R);
                dfs(node, node.right, false, L, R);
            } else if (node.val < L) {
                before.left = null;
                dfs(before, node.right, flag, L, R);
            } else {
                before.right = null;
                dfs(before, node.left, flag, L, R);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(0);
        s.right = new TreeNode(2);

        TreeNode node  = trimBSTResult1(s, 0,3);
        System.out.println(node.val + " " + node.left.val + " " + node.right.val);
    }
}
