import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : sortedSquares.java
 * Time       : Create on 19-4-18
 * Location   : ../Home/JavaForLeetCode/sortedSquares.java
 * Function   : LeetCode No.977
 */
public class sortedSquares {

    private static int[] sortedSquaresResult(int[] A) {
        int[] sum = new int[A.length];
        for (int i = 0; i < A.length; i++)
            sum[i] = A[i] * A[i];
        Arrays.sort(sum);
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquaresResult(A)));
    }
}
