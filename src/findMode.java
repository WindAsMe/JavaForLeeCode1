import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : findMode.java
 * Time       : Create on 18-7-7
 * Location   : ../Home/JavaForLeeCode/findMode.java
 * Function   : LeeCode No.501
 */
public class findMode {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int[] findModeResult(TreeNode root) {
        // map to count the occur time
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        System.out.println(map.toString());
        int maxFrequence = 0;
        int occurTimes = 0;

        for (Map.Entry<Integer, Integer> a : map.entrySet()) {
            if (a.getValue() > maxFrequence) {
                maxFrequence = a.getValue();
                occurTimes = 1;
            } else if (a.getValue() == maxFrequence)
                occurTimes ++;
        }

        int[] ans = new int[occurTimes];
        int i = 0;

        for (Map.Entry<Integer, Integer> a : map.entrySet()) {
            if (a.getValue() == maxFrequence) {
                ans[i] = a.getKey();
                i ++;
            }
        }

        return ans;
    }

    private static void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node != null) {
            Integer temp = map.get(node.val);
            if (temp == null)
                map.put(node.val, 1);
            else
                map.put(node.val, ++ temp);
            dfs(node.left, map);
            dfs(node.right, map);
        }
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.left.left = new TreeNode(2);
        s.left.right = new TreeNode(2);
        s.right = new TreeNode(6);
        System.out.println(Arrays.toString(findModeResult(s)));
    }

}
