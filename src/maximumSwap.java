
/**
 * Author     : WindAsMe
 * File       : maximumSwap.java
 * Time       : Create on 18-7-5
 * Location   : ../Home/JavaForLeeCode/maximumSwap.java
 * Function   : LeeCode No.670
 */
public class maximumSwap {

    private static int maximumSwapResult(int num) {
        // to char array is more simple
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++)
            buckets[digits[i] - '0'] = i;

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwapResult(92510));
    }
}
