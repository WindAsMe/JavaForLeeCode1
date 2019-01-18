/**
 * Author     : WindAsMe
 * File       : maxCount.java
 * Time       : Create on 18-6-28
 * Location   : ../Home/JavaForLeeCode/maxCount.java
 * Function   : LeeCode No.598
 */
public class maxCount {

    private static int maxCountResult(int m, int n, int[][] ops) {
        int len = ops.length;
        if(len<  1)
            return m * n;

        int min_a = Integer.MAX_VALUE;
        int min_b = Integer.MAX_VALUE;
        for (int[] op : ops) {
            int a = op[0];
            int b = op[1];
            min_a = Math.min(a, min_a);
            min_b = Math.min(b, min_b);
        }
        return min_a * min_b;
    }

    public static void main(String[] args) {
        int[][] ops = {};
        System.out.println(maxCountResult(3,4,ops));
    }
}
