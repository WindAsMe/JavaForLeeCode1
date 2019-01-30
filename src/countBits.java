import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : countBits.java
 * Time       : Create on 18-7-16
 * Location   : ../Home/JavaForLeeCode/countBits.java
 * Function   : LeeCode No.338
 */
public class countBits {

    private static int[] countBitsResult(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i ++ )
            ans[i] = helper(i);
        return ans;
    }

    private static int helper(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println(Arrays.toString(countBitsResult(num)));
    }
}
