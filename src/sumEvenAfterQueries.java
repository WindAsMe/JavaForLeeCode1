import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : sumEvenAfterQueries.java
 * Time       : Create on 19-4-19
 * Location   : ../Home/JavaForLeetCode/sumEvenAfterQueries.java
 * Function   : LeetCode No.985
 */
public class sumEvenAfterQueries {

    private static int[] sumEvenAfterQueriesResult(int[] A, int[][] queries) {
        int[] sum = new int[A.length];
        int row = 0;
        int previous = 0;
        for (int a : A) {
            if (a % 2 == 0)
                previous += a;
        }
        for (int[] query : queries) {
            int before = A[query[1]];
            int after = A[query[1]] + query[0];
            A[query[1]] += query[0];
            if (Math.abs(before % 2) == 1 && after % 2 == 0)
                previous += after;
            if (before % 2 == 0 && after % 2 == 0)
                previous += (after - before);
            if (before % 2 == 0 && Math.abs(after % 2) == 1)
                previous -= before;

            // System.out.println("before: " + before + "  after: " + after + "  p: " + previous);
            sum[row] = previous;
            row++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueriesResult(A, queries)));
    }
}
