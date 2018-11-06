/**
 * Author     : WindAsMe
 * File       : findNthDigit.java
 * Time       : Create on 18-6-25
 * Location   : ../Home/JavaForLeeCode/findNthDigit.java
 * Function   : LeeCode No.400
 */
public class findNthDigit {

    private static int findNthDigitResult(int n) {
        long sum = 0;
        long  tens = 1;
        int i;
        for (i = 1; sum < n; ++i, tens *= 10) {
            sum += i * tens * 9;
        }
        tens /= 10;
        --i;
        sum -= tens * 9 * i;
        int dif = (int) (n - sum);
        int whichNum = (int) (dif / i + tens);
        int yu = dif % i;
        if (yu == 0)
            return (whichNum - 1) % 10;
        while (--yu > 0)
            tens /= 10;
        whichNum /= tens;
        return whichNum % 10;
    }



//    // 1 to 9: 9
//    // 10 to 99: 90 * 2
//    // 100 to 999: 900 * 3
//    // ...
//    private static int findNthDigitResult(int n) {
//        if (n < 10) {
//            return n;
//        }
//        // mark is the start
//        int mark = 1;
//        // i is the length
//        int i = 1;
//        // In three procedure to locate the number
//        // 1. locate the number length
//        // 2. locate the number
//        // 3. locate the result
//        for (; i < n; i ++) {
//            if (n - 9 * mark * i >= 0) {
//                n -= 9 * mark * i;
//                mark *= 10;
//            } else {
//                break;
//            }
//        }
//        while (n - i > 0) {
//            mark += 1;
//            n -= i;
//        }
//
//        return String.valueOf(mark).charAt(n - 1) - '0';
//    }

    public static void main(String[] args) {
        System.out.println(findNthDigitResult(17));
    }
}
