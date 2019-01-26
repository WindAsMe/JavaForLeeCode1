/**
 * Author     : WindAsMe
 * File       : isPerfectSquare.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/isPerfectSquare.java
 * Function   : LeeCode No.367
 */
public class isPerfectSquare {

    private static boolean isPerfectSquareResult(int num) {
        double result = Math.sqrt(num);
        return (int)result * (int)result == num;
    }


    public static void main(String[] args) {
        int num = 808201;
        System.out.println(isPerfectSquareResult(num));
    }
}
