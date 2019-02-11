import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : findUnsortedSubarray.java
 * Time       : Create on 18-6-27
 * Location   : ../Home/JavaForLeeCode/findUnsortedSubarray.java
 * Function   : LeeCode No.581
 */
public class findUnsortedSubarray {

    private static int findUnsortedSubarrayResult1(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int begin, end;
        begin = end = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if(nums[i] > max)
                max = nums[i];
            if(nums[i] < nums[i - 1])
                end = i;
            if(nums[i] < max)
                end = i;
        }
        int min = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i --) {
            if(nums[i] < min)
                min = nums[i];
            if(nums[i] > nums[i + 1])
                begin = i;
            if(nums[i] > min)
                begin = i;
        }
        return end == 0 ? 0 : end - begin + 1;
    }

    // After sort and compare
    private static int findUnsortedSubarrayResult2(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int start = 0;
        int end = nums.length - 1;
        for (; start < nums.length; start ++) {
            if (nums[start] != copy[start])
                break;
        }
        for (; end > 0; end --) {
            if (nums[end] != copy[end])
                break;
        }
        if (start >= end)
            return 0;
        else
            return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findUnsortedSubarrayResult2(nums));
    }
}
