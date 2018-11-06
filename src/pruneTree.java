/**
 * Author     : WindAsMe
 * File       : pruneTree.java
 * Time       : Create on 18-11-6
 * Location   : ../Home/JavaForLeeCode/pruneTree.java
 * Function   : LeeCode No.814
 */
public class pruneTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode pruneTree(TreeNode root) {
        iteration(root.left, root, true);
        iteration(root.right, root, false);
        return root;
    }

    private static void iteration(TreeNode son, TreeNode dad, boolean left) {
        if (son != null) {
            if (son.val == 1) {
                iteration(son.left, son, true);
                iteration(son.right, son, false);
            } else {
                if (trim(son) && left) {
                    dad.left = null;
                    iteration(son.right, son, false);
                } else if (trim(son) && !left) {
                    dad.right = null;
                    iteration(son.left, son, true);
                } else {
                    iteration(son.left, son, true);
                    iteration(son.right, son, false);
                }
            }
        }
    }

    private static boolean trim(TreeNode node) {
        if (node == null)
            return true;
        if (node.val == 1)
            return false;
        return trim(node.left) && trim(node.right);
    }

    private static void print(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            print(node.left);
            print(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(0);

        node.right = new TreeNode(0);
        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(1);
        print(pruneTree(node));
    }
}

