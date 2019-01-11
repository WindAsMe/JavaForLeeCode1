/**
 * Author     : WindAsMe
 * File       : tree2str.java
 * Time       : Create on 18-7-18
 * Location   : ../Home/JavaForLeeCode/tree2str.java
 * Function   : LeeCode No.606
 */
public class tree2str {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static String tree2strResult(TreeNode t) {
        if (t == null)
            return "";
        String result = t.val + "";
        String left = tree2strResult(t.left);
        String right = tree2strResult(t.right);

        if ("".equals(left) && "".equals(right))
            return result;
        if ("".equals(left))
            return result + "()" + "(" + right + ")";
        if ("".equals(right))
            return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(5);
        System.out.println(tree2strResult(s));
    }
}
