
/**
 * Author     : WindAsMe
 * File       : deleteNode.java
 * Time       : Create on 18-7-18
 * Location   : ../Home/JavaForLeeCode/deleteNode.java
 * Function   : LeeCode No.450
 */
public class deleteNode {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private static TreeNode deleteNodeResult(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key){
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            root.val = findReplacement(root,root.left,true);
        } else{
            if(root.val > key)
                root.left = deleteNodeResult(root.left,key);
            else
                root.right = deleteNodeResult(root.right,key);
        }
        return root;

    }


    private static int findReplacement(TreeNode parent, TreeNode node, boolean isLeft){
        if(node.right == null){
            if (isLeft)
                parent.left = node.left;
            else parent.right = node.left;
            return node.val;
        }
        return findReplacement(node,node.right,false);
    }

    private static void iteration(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            iteration(node.left);
            iteration(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);

        node.right = new TreeNode(6);
        node.right.right = new TreeNode(7);

        TreeNode ans = deleteNodeResult(node, 4);
        iteration(ans);
    }
}
