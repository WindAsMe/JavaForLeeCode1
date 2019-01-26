/**
 * Author     : WindAsMe
 * File       : isPowerOfThree.java
 * Time       : Create on 18-6-10
 * Location   : ../Home/JavaForLeeCode/isPowerOfThree.java
 * Function   : LeeCode No.326
 */
public class isPowerOfThree {

    private static boolean isPowerOfThreeResult(int n) {
        if (n <= 0 || n == 2)
            return false;
        if (n == 1)
            return true;
        int temp = n / 3;
        while (temp != 0) {
            if (n % 2 == 0 || temp % 2 == 0 || temp * 3 != n) {
                return false;
            } else {
                n = temp;
                temp = temp / 3;
            }
        }
        return true;
    }
}
