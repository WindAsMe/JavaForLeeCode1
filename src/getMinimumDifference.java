import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : getMinimumDifference.java
 * Time       : Create on 18-7-7
 * Location   : ../Home/JavaForLeeCode/getMinimumDifference.java
 * Function   : LeeCode No.530
 */
public class getMinimumDifference {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Most efficient.
    private static int min = Integer.MAX_VALUE;
    private static TreeNode prev = null;
    private static int getMinimumDifferenceResult2(TreeNode root) {
        if (root == null)
            return min;
        getMinimumDifferenceResult2(root.left);
        if (prev != null)
            min = Math.min(min, root.val - prev.val);
        prev = root;
        getMinimumDifferenceResult2(root.right);
        return min;
    }


    // Save all node value to list
    // Trans to array problem
    private static int getMinimumDifferenceResult(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        } else {
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            System.out.println(list.toString());
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++)
                    min = Math.min(min, Math.abs(list.get(j) - list.get(i)));
            }
            return min;
        }
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }


    // Find the constant two node
    private static int getMinimumDifferenceResult1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        else
            return Math.min(dfs1(root.left, root.val), dfs1(root.right, root.val));
    }

    private static int dfs1(TreeNode node, int value) {
        if (node != null)
            // find the smallest in current minus, left minus and right minus.
            return Math.min(Math.min(dfs1(node.left, node.val), dfs1(node.right, node.val)), Math.abs(node.val - value));
        else
            return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(6);
        s.left.left = new TreeNode(7);
        s.left.right = new TreeNode(12);
        s.right = new TreeNode(15);

        System.out.println(getMinimumDifferenceResult(s));
    }
}
