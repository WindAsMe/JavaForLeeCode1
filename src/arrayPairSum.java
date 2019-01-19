import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : arrayPairSum.java
 * Time       : Create on 18-6-19
 * Location   : ../Home/JavaForLeeCode/arrayPairSum.java
 * Function   : LeeCode No.561
 */
public class arrayPairSum {

    private static int arrayPairSumResult(int[] nums) {
        if (nums.length < 2)
            return 0;
        else {
            int count = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2)
                count += nums[i];
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,3,6,9,3};
        System.out.println(arrayPairSumResult(nums));
    }
}
