import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findTarget.java
 * Time       : Create on 18-7-1
 * Location   : ../Home/JavaForLeeCode/findTarget.java
 * Function   : LeeCode No.653
 */
public class findTarget {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean findTargetResult(TreeNode root, int k) {
        if (root == null)
            return false;
        else {
            boolean flag;
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            for (Integer aList : list) {
                // Default the BST has no equal value
                // If has the equality, It's not instrumental
                if (k - aList == aList)
                    continue;
                flag = find(root, k - aList);
                if (flag)
                    return true;
            }
            return false;
        }
    }

    // Iteration for every node
    private static void dfs(TreeNode root, List<Integer> list) {
         if (root != null) {
             list.add(root.val);
             dfs(root.left, list);
             dfs(root.right, list);
         }
    }

    // Find if exist another node
    private static boolean find(TreeNode root, int target) {
        if (root == null)
            return false;
        else {
            if (root.val == target)
                return true;
            else if (root.val > target)
                return find(root.left, target);
            else
                return find(root.right, target);
        }
    }


    // find the constant 2 node addition
//    private static boolean dfs(TreeNode root, int target) {
//        if (root == null) {
//            return false;
//        } else {
//            if (root.left != null && root.right != null) {
//                if (root.val + root.left.val == target || root.val + root.right.val == target) {
//                    return true;
//                } else {
//                    return dfs(root.left, target) || dfs(root.right, target);
//                }
//            } else if (root.left == null && root.right != null) {
//                if (root.val + root.right.val == target) {
//                    return true;
//                } else {
//                    return dfs(root.right, target);
//                }
//            }else if (root.left != null) {
//                if (root.val + root.left.val == target) {
//                    return true;
//                } else {
//                    return dfs(root.left, target);
//                }
//            } else {
//                return false;
//            }
//        }
//    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(5);
        s.left = new TreeNode(3);
        s.left.left = new TreeNode(2);
        s.left.right = new TreeNode(4);

        s.right = new TreeNode(6);
        s.right.right = new TreeNode(7);
        System.out.println(findTargetResult(s, 9));
    }
}
