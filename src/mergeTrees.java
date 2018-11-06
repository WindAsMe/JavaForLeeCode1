/**
 * Author     : WindAsMe
 * File       : mergeTrees.java
 * Time       : Create on 18-6-29
 * Location   : ../Home/JavaForLeeCode/mergeTrees.java
 * Function   : LeeCode No.617
 */
public class mergeTrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode mergeTreesResult(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            TreeNode treeNode = new TreeNode(t1.val + t2.val);
            treeNode.left = mergeTreesResult(t1.left, t2.left);
            treeNode.right = mergeTreesResult(t1.right, t2.right);
            return treeNode;
        } else if (t1 != null) {
            return t1;
        } else if (t2 != null) {
            return t2;
        } else {
            return null;
        }
    }
    // In DFS iteration
//    private static void DFS(TreeNode t1, TreeNode t2, TreeNode ans) {
//        if (t1 != null && t2 != null) {
//            ans.val = t1.val + t2.val;
//            if (t1.left != null || t2.left != null) {
//                ans.left = new TreeNode(0);
//                DFS(t1.left, t2.left, ans.left);
//            }
//            if (t1.right != null || t2.right != null) {
//                ans.right = new TreeNode(0);
//                DFS(t1.right, t2.right, ans.right);
//            }
//            return;
//        } else if (t1 != null) {
//            ans.val = t1.val;
//            if (t1.left != null) {
//                ans.left = new TreeNode(0);
//                DFS(t1.left, null, ans.left);
//            }
//            if (t1.right != null) {
//                ans.right = new TreeNode(0);
//                DFS(t1.right, null, ans.right);
//            }
//        } else if (t2 != null) {
//            ans.val = t2.val;
//            if (t2.left != null) {
//                ans.left = new TreeNode(0);
//                DFS(null, t2.left, ans.left);
//            }
//            if (t2.right != null) {
//                ans.right = new TreeNode(0);
//                DFS(null, t2.right, ans.right);
//            }
//        }
//    }
//
//
//    private static TreeNode mergeTreesResult(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) {
//            return null;
//        }
//        TreeNode ans = new TreeNode(0);
//        DFS(t1, t2, ans);
//        return ans;
//    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
    }
}
