import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : isSameTree.java
 * Time       : Create on 18-5-29
 * Location   : ../Home/JavaForLeeCode/isSameTree.java
 * Function   : LeeCode No.65
 */
public class isSameTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean isSameTreeResult(TreeNode p, TreeNode q) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        DFS(p, left);
        DFS(q, right);

        System.out.println(left);
        System.out.println(right);
        if (left.size() != right.size())
            return false;
        else {
            for (int i = 0; i < left.size(); i++) {
                if (!left.get(i).equals(right.get(i)))
                    return false;
            }
            return true;
        }
    }
    private static void DFS(TreeNode root, List<Integer> values){
        if (root != null) {
            DFS(root.left, values);
            values.add(root.val);
            DFS(root.right, values);
        } else
            values.add(Integer.MAX_VALUE);
    }

    public static void main(String[] args){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = null;
        q.right = new TreeNode(2);
        System.out.println(isSameTreeResult(p, q));


    }
}
