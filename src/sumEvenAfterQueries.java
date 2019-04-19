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
        for (int[] query : queries) {
            A[query[1]] += query[0];
            sum[row] = findDouble(A);
            row++;
        }
        return sum;
    }

    private static int findDouble(int[] A) {
        int sum = 0;
        for (int a : A) {
            if (a % 2 == 0)
                sum += a;
        }
        return sum;
    }
}
