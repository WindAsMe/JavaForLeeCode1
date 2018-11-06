
/**
 * Author     : WindAsMe
 * File       : diameterOfBinaryTree.java
 * Time       : Create on 18-8-1
 * Location   : ../Home/JavaForLeeCode/diameterOfBinaryTree.java
 * Function   : LeeCode No.543
 */
public class diameterOfBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static int diameterOfBinaryTreeResult(TreeNode root) {
        if (root == null)
            return 0;
        int curLeft = 0;
        int curRight = 0;
        int[] maxLeft = new int[1];
        int[] maxRight = new int[1];
        maxDepth(root.left, curLeft, maxLeft);
        maxDepth(root.right, curRight, maxRight);
        return maxLeft[0] + maxRight[0];
    }

    private static void maxDepth(TreeNode node, int current, int[] max) {
        if (node == null) {
            max[0] = Math.max(current, max[0]);
        } else {
            current++;
            maxDepth(node.left, current, max);
            maxDepth(node.right, current, max);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node.right = new TreeNode(3);

        System.out.println(diameterOfBinaryTreeResult(node));
    }
}
