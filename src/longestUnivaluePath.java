/**
 * Author     : WindAsMe
 * File       : longestUnivaluePath.java
 * Time       : Create on 18-7-6
 * Location   : ../Home/JavaForLeeCode/longestUnivaluePath.java
 * Function   : LeeCode No.687
 */
public class longestUnivaluePath {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private static int result=0;
    //返回沿着某条子树直走能到达的最大值
    private static int singleLength(TreeNode root){
        int countL = 0, countR = 0;
        if(root.left != null){
            if(root.left.val == root.val)
                countL = singleLength(root.left);
            else
                singleLength(root.left);
        }
        if(root.right != null){
            if(root.right.val == root.val)
                countR = singleLength(root.right);
            else
                singleLength(root.right);
        }
        if(countL + countR > result)
            result = countL + countR;
        return Math.max(countL, countR) + 1;
    }

    private static int longestUnivaluePathResult1(TreeNode root) {
        if(root == null)
            return 0;
        singleLength(root);
        return result;
    }



    private static int longestUnivaluePathResult(TreeNode root) {
        if (root == null)
            return 0;
        // Location passed
        int[] longestPath = new int[1];
        getUnivaluePathCount(root, longestPath);
        return longestPath[0];
    }
    private static int getUnivaluePathCount(TreeNode node, int[] longestPath) {
        int left = 0;
        if (node.left != null) {
            left += getUnivaluePathCount(node.left, longestPath);
            if (node.val == node.left.val)
                left += 1;
            else
                left = 0;
        }
        int right = 0;
        if (node.right != null) {
            right += getUnivaluePathCount(node.right, longestPath);
            if (node.val == node.right.val)
                right += 1;
            else
                right = 0;
        }
        int currentLongestPath;
        if (node.left != null && node.right != null && node.left.val == node.right.val) {
            currentLongestPath = left + right;
        } else {
            currentLongestPath = Math.max(left, right);
        } if (currentLongestPath > longestPath[0]) {
            longestPath[0] = currentLongestPath;
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(5);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(1);

        s.right = new TreeNode(5);
        s.right.right = new TreeNode(5);

        System.out.println(longestUnivaluePathResult(s));
    }
}
