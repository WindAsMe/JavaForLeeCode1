/**
 * Author     : WindAsMe
 * File       : sumNumbers.java
 * Time       : Create on 18-7-15
 * Location   : ../Home/JavaForLeeCode/sumNumbers.java
 * Function   : LeeCode No.129
 */
public class sumNumbers {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // In LeetCode, No more global variable
    // private static int total = 0;
    private static int sumNumbersResult(TreeNode root) {
        if (root == null)
            return 0;
        int[] total = new int[]{0};
        dfs(root, 0, total);
        return total[0];
    }

    private static void dfs(TreeNode node, int before, int[] total) {
        if (node.left == null && node.right == null) {
            total[0] += before * 10 + node.val;
            //System.out.println("before: " + before);
        } else {
            if (node.left != null)
                dfs(node.left, before * 10 + node.val, total);
            if (node.right != null)
                dfs(node.right, before * 10 + node.val, total);
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(4);
        s.left = new TreeNode(9);
        s.left.left = new TreeNode(5);
        s.left.right = new TreeNode(1);

        s.right = new TreeNode(0);
        System.out.println(sumNumbersResult(s));
    }
}
