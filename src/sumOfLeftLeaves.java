/**
 * Author     : WindAsMe
 * File       : sumOfLeftLeaves.java
 * Time       : Create on 18-6-25
 * Location   : ../Home/JavaForLeeCode/sumOfLeftLeaves.java
 * Function   : LeeCode No.404
 */
public class sumOfLeftLeaves {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int sumOfLeftLeavesResult(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return dfs(root.left, true) + dfs(root.right, false);
        }
    }

    // dfs searching node
    // isLeft mark the is or not the left node
    private static int dfs(TreeNode node, boolean isLeft){
        if (node == null) {
            return 0;
        } else {
            if (node.left == null && node.right == null && isLeft) {
                return node.val;
            } else {
                return dfs(node.left, true) + dfs(node.right, false);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(sumOfLeftLeavesResult(node));
    }
}
