/**
 * Author     : WindAsMe
 * File       : rob.java
 * Time       : Create on 18-7-29
 * Location   : ../Home/JavaForLeeCode/rob.java
 * Function   : LeeCode No.337
 */
public class rob {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int robResult(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] dfs(TreeNode n){
        if (n == null)
            return new int[2];
        int[] left = dfs(n.left);
        int[] right= dfs(n.right);
        int[] res= new int[2];
        res[0] = n.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(1);
        System.out.println(robResult(node));
    }
}
