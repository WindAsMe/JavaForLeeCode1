/**
 * Author     : WindAsMe
 * File       : hammingDistance.java
 * Time       : Create on 18-6-18
 * Location   : ../Home/JavaForLeeCode/hammingDistance.java
 * Function   : LeeCode No.461
 */
public class hammingDistance {

    private static int hammingDistanceResult(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        System.out.println(hammingDistanceResult(x, y));
    }
}
