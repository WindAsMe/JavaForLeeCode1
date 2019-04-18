/**
 * Author     : WindAsMe
 * File       : bitwiseComplement.java
 * Time       : Create on 19-4-18
 * Location   : ../Home/JavaForLeetCode/bitwiseComplement.java
 * Function   : LeetCode No.1009
 */
public class bitwiseComplement {

    private static int bitwiseComplementResult(int N) {
        if (N == 0)
            return 1;
        int t = N ^ Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0, d = 1; i < 30 && N != 0; i++, N /= 2) {
            sum += d*((t>>i)&1);
            d *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(bitwiseComplementResult(N));
    }
}
