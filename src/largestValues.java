import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : largestValues.java
 * Time       : Create on 18-7-30
 * Location   : ../Home/JavaForLeeCode/largestValues.java
 * Function   : LeeCode No.515
 */
public class largestValues {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<Integer> largestValuesResult(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()) {
            // System.out.println("here");
            int max = Integer.MIN_VALUE;
            if (!stack1.empty()) {
                while (!stack1.empty()) {
                    TreeNode node = stack1.pop();
                    max = Math.max(max, node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
                list.add(max);
                continue;
            }
            if (!stack2.empty()) {
                while (!stack2.empty()) {
                    TreeNode node = stack2.pop();
                    max = Math.max(max, node.val);
                    if (node.left != null)
                        stack1.push(node.left);
                    if (node.right != null)
                        stack1.push(node.right);
                }
                list.add(max);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);

        node.right = new TreeNode(2);
        node.right.right = new TreeNode(9);
        System.out.println(largestValuesResult(node).toString());
    }
}
