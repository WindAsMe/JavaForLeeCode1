import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : zigzagLevelOrder.java
 * Time       : Create on 18-7-14
 * Location   : ../Home/JavaForLeeCode/zigzagLevelOrder.java
 * Function   : LeeCode No.103
 */
public class zigzagLevelOrder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // In recursion
    private static List<List<Integer>> zigzagLevelOrderResult1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    private static void dfs(TreeNode cur, List<List<Integer>> ans, int depth){
        if (cur == null)
            return;
        if (ans.size() == depth) {
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        if(depth % 2 == 0)
            ans.get(depth).add(cur.val);
        else
            ans.get(depth).add(0, cur.val);
        dfs(cur.left, ans, depth + 1);
        dfs(cur.right, ans, depth + 1);
    }


    // In Iteration
    private static List<List<Integer>> zigzagLevelOrderResult(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root);
        while (!left.empty() || !right.empty()) {
            if (!left.empty()) {
                List<Integer> list = new ArrayList<>();
                while (!left.empty()) {
                    TreeNode node = left.pop();
                    list.add(node.val);
                    if (node.left != null)
                        right.push(node.left);
                    if (node.right != null)
                        right.push(node.right);
                }
                lists.add(list);

            }
            if (!right .empty()) {
                List<Integer> list = new ArrayList<>();
                while (!right.empty()) {
                    TreeNode node = right.pop();
                    System.out.println("in right: " + node.val);
                    list.add(node.val);
                    if (node.right != null)
                        left.push(node.right);
                    if (node.left != null)
                        left.push(node.left);

                }
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);
        List<List<Integer>> lists = zigzagLevelOrderResult(s);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
