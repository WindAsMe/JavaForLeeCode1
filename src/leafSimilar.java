import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : leafSimilar.java
 * Time       : Create on 18-7-22
 * Location   : ../Home/JavaForLeeCode/leafSimilar.java
 * Function   : LeeCode No.872
 */
public class leafSimilar {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean leafSimilarResult(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    private static void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            } else {
                dfs(node.left, list);
                dfs(node.right, list);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(2);
        t.right = new TreeNode(5);
        System.out.println(leafSimilarResult(s, t));
    }
}