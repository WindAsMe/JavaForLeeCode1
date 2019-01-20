/**
 * Author     : WindAsMe
 * File       : divide.java
 * Time       : Create on 18-7-8
 * Location   : ../Home/JavaForLeeCode/divide.java
 * Function   : LeeCode No.29
 */
public class divide {

    private static int divideResult1(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor); //-2147483648的相反数还为-2147483648，因此需要用转型为long
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int res = 0;
        while (m >= n) {
            long temp = n;
            int val = 1;
            while(m >= (temp << 1)){
                temp <<= 1;
                val <<= 1;
            }
            //System.out.println(temp +" "+val);
            m -= temp;
            res += val;
        }
        return sign == 1 ? res : 0 - res;
    }


    private static int divideResult(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        return dividend / divisor;
    }

    public static void main(String[] args) {
        System.out.println(divideResult(-2147483648, -1));
    }
}
