import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : searchRange.java
 * Time       : Create on 18-7-8
 * Location   : ../Home/JavaForLeeCode/searchRange.java
 * Function   : LeeCode No.34
 */
public class searchRange {

    private static int[] searchRangeResult(int[] nums, int target) {
        int[] res= {-1, -1};
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return res;
        int left = 0, right = nums.length - 1;
        while (left < right){
            int center = (left + right) / 2;
            if (nums[center] < target)
                left = center + 1;
            else
                right = center;
        }
        if (nums[left] != target)
            return res;
        else
            res[0] = left;
        right = nums.length-1;
        while (left < right){
            int center = (left + right) / 2 + 1;
            if (nums[center] > target)
                right = center - 1;
            else
                left = center;
        }
        res[1]= left;
        return res;
    }


    private static int binaryFind(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (end - start > 1) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
                mid = (start + end) / 2;
            } else {
                start = mid;
                mid = (start + end) / 2;
            }
        }
        if (nums[start] != target && nums[end] != target) {
            return -1;
        } else {
            if (nums[start] == target ) {
                return start;
            } else {
                return end;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4};
        //System.out.println(Arrays.toString(searchRangeResult(nums, 4)));

        int[] nums1 = {1,6,7,8,9,10,14,22,67,88,90,650};
        System.out.println(binaryFind(nums1, 88));
    }
}
