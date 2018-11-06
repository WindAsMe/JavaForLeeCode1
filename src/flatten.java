/**
 * Author     : WindAsMe
 * File       : flatten.java
 * Time       : Create on 18-7-13
 * Location   : ../Home/JavaForLeeCode/flatten.java
 * Function   : LeeCode No.114
 */
public class flatten {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static void flattenResult(TreeNode root) {
        trans(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    private static TreeNode trans(TreeNode root){
        if(root == null)
            return null;
        TreeNode right = trans(root.right);
        root.right = trans(root.left);
        root.left = null;
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);
        flattenResult(s);
    }
}

