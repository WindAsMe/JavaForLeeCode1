/**
 * Author     : WindAsMe
 * File       : countNodes.java
 * Time       : Create on 18-7-17
 * Location   : ../Home/JavaForLeeCode/countNodes.java
 * Function   : LeeCode No.222
 */
public class countNodes {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static int countNodesResult(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth=0;
        int rightDepth=0;
        for(TreeNode node = root; node != null; node = node.left)
            leftDepth ++;
        for(TreeNode node = root; node != null; node = node.right)
            rightDepth ++;
        if (leftDepth == rightDepth)
            return (1 << leftDepth) - 1;
        else
            return countNodesResult(root.left) + countNodesResult(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);
        System.out.println(countNodesResult(s));
    }
}
