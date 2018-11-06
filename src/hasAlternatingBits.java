/**
 * Author     : WindAsMe
 * File       : hasAlternatingBits.java
 * Time       : Create on 18-7-19
 * Location   : ../Home/JavaForLeeCode/hasAlternatingBits.java
 * Function   : LeeCode No.693
 */
public class hasAlternatingBits {

    private static boolean hasAlternatingBitsResult(int n) {
        boolean isOne = n % 2 == 1;
        while (n != 0) {
            n = n >> 1;
            if (isOne && n % 2 == 0) {
                isOne = false;
                continue;
            }
            if (!isOne && n % 2 == 1) {
                isOne = true;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBitsResult(10));
    }
}
