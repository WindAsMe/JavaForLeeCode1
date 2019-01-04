import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : fourSumCount.java
 * Time       : Create on 18-12-27
 * Location   : ../Home/JavaForLeetCode/fourSumCount.java
 * Function   : LeetCode No.454
 */
public class fourSumCount {

    private static int fourSumCountResult(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> mapAB = new HashMap<>();
        int length = A.length;
        int sum;
        for (int aA : A) {
            for (int j = 0; j < length; j++) {
                sum = aA + B[j];
                mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum = C[i] + D[j];
                if (mapAB.containsKey(-sum))
                    result += mapAB.get(-sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        System.out.println(fourSumCountResult(A, B, C, D));
    }
}
