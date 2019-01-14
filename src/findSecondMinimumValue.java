/**
 * Author     : WindAsMe
 * File       : findSecondMinimumValue.java
 * Time       : Create on 18-7-3
 * Location   : ../Home/JavaForLeeCode/findSecondMinimumValue.java
 * Function   : LeeCode No.671
 */
public class findSecondMinimumValue {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int findSecondMinimumValueResult(TreeNode root) {
        if (root == null)
            return -1;
        else {
            int left = dfs(root.left, root.val, Integer.MAX_VALUE);
            int right = dfs(root.right, root.val, Integer.MAX_VALUE);
            System.out.println(left + " " + right);
            return left != Integer.MAX_VALUE || right != Integer.MAX_VALUE ? Math.min(left, right) : -1;
        }
    }

    // min is the smallest
    // current is current the second
    private static int dfs(TreeNode node, int min, int current) {
        if (node != null) {
            if (node.val != min && node.val < current)
                return Math.min(dfs(node.left, min, node.val), dfs(node.right, min, node.val));
            else
                return Math.min(dfs(node.left, min, current), dfs(node.right, min, current));
        } else
            return current;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(2);
        s.left = new TreeNode(3);

        s.right = new TreeNode(4);
//        s.right.left = new TreeNode(2);
//        s.right.right = new TreeNode(7);

        System.out.println(findSecondMinimumValueResult(s));
    }
}
