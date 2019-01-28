/**
 * Author     : WindAsMe
 * File       : judgeSquareSum.java
 * Time       : Create on 18-8-20
 * Location   : ../Home/JavaForLeeCode/judgeSquareSum.java
 * Function   : LeeCode No.633
 */
public class judgeSquareSum {

    private static boolean judgeSquareSumResult(int c) {
        if (c == 0)
            return true;
        int limit = (int) Math.sqrt(c);
        for (int i = 1; i <= limit; i++) {
            int j = (int) Math.sqrt(c - i * i);
            if (i * i + j * j == c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 0;
        System.out.println(judgeSquareSumResult(c));
    }
}
