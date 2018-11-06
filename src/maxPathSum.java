
/**
 * Author     : WindAsMe
 * File       : maxPathSum.java
 * Time       : Create on 18-7-14
 * Location   : ../Home/JavaForLeeCode/maxPathSum.java
 * Function   : LeeCode No.124
 */
public class maxPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static int maxPathSumResult(TreeNode root) {
        int[] maxValue = new int[]{Integer.MIN_VALUE};

        if(root == null)
            return 0;
        helper(root, maxValue);
        return maxValue[0];
    }

    private static int helper(TreeNode node, int[] maxValue) {
        if (node == null)
            return 0;
        int left = Math.max(helper(node.left, maxValue), 0);
        int right = Math.max(helper(node.right, maxValue), 0);
        maxValue[0] = Math.max(maxValue[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(2);
        s.left = new TreeNode(5);
        System.out.println(maxPathSumResult(s));
    }
}
