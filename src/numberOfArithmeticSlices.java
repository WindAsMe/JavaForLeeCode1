/**
 * Author     : WindAsMe
 * File       : numberOfArithmeticSlices.java
 * Time       : Create on 18-7-29
 * Location   : ../Home/JavaForLeeCode/numberOfArithmeticSlices.java
 * Function   : LeeCode No.413
 */
public class numberOfArithmeticSlices {

    private static int numberOfArithmeticSlicesResult(int[] A) {
        if (A.length < 3)
            return 0;
        int[] helper = new int[A.length];
        for (int i = 2; i < helper.length; i++) {
            if (A[i - 1] * 2 == A[i] + A[i - 2])
                helper[i] = helper[i - 1] + 1;
        }
        int ans = 0;
        for (int i = 2; i < helper.length; i++)
            ans += helper[i];
        // System.out.println(Arrays.toString(helper));
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,7,9};
        System.out.println(numberOfArithmeticSlicesResult(nums));
    }
}
