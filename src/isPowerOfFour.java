/**
 * Author     : WindAsMe
 * File       : isPowerOfFour.java
 * Time       : Create on 18-6-10
 * Location   : ../Home/JavaForLeeCode/isPowerOfFour.java
 * Function   : LeeCode No.342
 */
public class isPowerOfFour {

    private static boolean isPowerOfFourResult(int num) {
        if (num < 4)
            return num == 1;
        int temp = num / 4;
        while (temp / 4 != 0) {
            if (temp * 4 != num)
                return false;
            num = temp;
            temp /= 4;
        }
        return temp * 4 == num && temp != 2;
    }

    public static void main(String[] args) {
        int num = 8;
        System.out.println(isPowerOfFourResult(num));
    }
}
