import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : maximumProduct.java
 * Time       : Create on 18-6-29
 * Location   : ../Home/JavaForLeeCode/maximumProduct.java
 * Function   : LeeCode No.628
 */
public class maximumProduct {

    // If has the negatives
    private static int maximumProductResult(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    public static void main(String[] args) {
        int[] nums = {1,4,6,7,-2,-7};
        System.out.println(maximumProductResult(nums));
    }
}
