import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : nextPermutation.java
 * Time       : Create on 18-7-20
 * Location   : ../Home/JavaForLeeCode/nextPermutation.java
 * Function   : LeeCode No.31
 */
public class nextPermutation {

    private static void nextPermutationResult(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        int len = nums.length;
        int index = len - 1;
        int value = nums[index];
        for (index = index - 1; index >= 0; index--) {
            if (nums[index] < value) {
                value = nums[index];
                break;
            }
            value = nums[index];
        }
        if (index < 0) {
            reversal(nums, 0, len - 1);
        } else {
            for (int j = len - 1; j > index; j--) {
                if (nums[j] > value) {
                    nums[index] = nums[j];
                    nums[j] = value;
                    reversal(nums, index + 1, len - 1);
                    break;
                }
            }
        }
    }

    private static void reversal(int[] nums, int start, int end) {
        int len = end + 1 - start;
        for (int i = 0; i < len / 2; i++) {
            int k = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = k;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,1,5};
        nextPermutationResult(nums);
    }
}
