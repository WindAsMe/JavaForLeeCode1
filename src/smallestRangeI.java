import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : smallestRangeI.java
 * Time       : Create on 18-12-21
 * Location   : ../Home/JavaForLeetCode/smallestRangeI.java
 * Function   : LeetCode No.908
 */
public class smallestRangeI {

    private static int smallestRangeIResult(int[] A, int K) {
        Arrays.sort(A);
        return A[A.length - 1] - A[0] <= 2 * K ? 0 : A[A.length - 1] - A[0] - 2 * K;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6};
        System.out.println(smallestRangeIResult(A, 3));
    }
}
