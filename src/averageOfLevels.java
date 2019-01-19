import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : averageOfLevels.java
 * Time       : Create on 18-6-29
 * Location   : ../Home/JavaForLeeCode/averageOfLevels.java
 * Function   : LeeCode No.637
 */
public class averageOfLevels {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static List<Double> averageOfLevelsResult1(TreeNode root) {
        if (null == root)
            return null;
        List<Integer> count = new ArrayList<>();
        List<Double> sum = new ArrayList<>();
        DFS(root, 0, sum, count);

        for (int i = 0; i < sum.size(); i++)
            sum.set(i, sum.get(i) / count.get(i));
        return sum;
    }

    // Use list index to substitute the tree's layer
    private static void DFS(TreeNode node, int i, List<Double> res, List<Integer> count) {
        if (null == node)
            return;
        if (i < res.size()) {
            res.set(i, res.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            res.add(1.0 * node.val);
            count.add(1);
        }
        DFS(node.left, i + 1, res, count);
        DFS(node.right, i + 1, res, count);
    }




    //
    private static List<Double> averageOfLevelsResult(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        else {
            // Layer iteration
            List<Double> list = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!(stack1.empty() && stack2.empty())) {
                if (!(stack1.empty())) {
                    double sum = 0;
                    int size = stack1.size();
                    while (!(stack1.empty())) {
                        TreeNode node = stack1.pop();
                        sum += node.val;
                        if (node.left != null) {
                            stack2.push(node.left);
                        }
                        if (node.right != null) {
                            stack2.push(node.right);
                        }
                    }
                    list.add(sum / size);
                } else {
                    double sum = 0;
                    int size = stack2.size();
                    while (!(stack2.empty())) {
                        TreeNode node = stack2.pop();
                        sum += node.val;
                        if (node.left != null) {
                            stack1.push(node.left);
                        }
                        if (node.right != null) {
                            stack1.push(node.right);
                        }
                    }
                    list.add(sum / size);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(9);

        s.right = new TreeNode(20);
        s.right.left = new TreeNode(15);
        s.right.right = new TreeNode(7);
        System.out.println(averageOfLevelsResult(s).toString());
    }
}
