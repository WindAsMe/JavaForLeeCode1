/**
 * Author     : WindAsMe
 * File       : searchBinary.java
 * Time       : Create on 18-7-29
 * Location   : ../Home/JavaForLeeCode/searchBinary.java
 * Function   : LeeCode No.704
 */
public class searchBinary {

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start + 1 < end) {
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                end = mid;
                mid = (start + end) / 2;
            } else {
                start = mid;
                mid = (start + end) / 2;
            }
        }
        if (nums[start] == target)
            return start;
        if (nums[mid] == target)
            return mid;
        if (nums[end] == target)
            return end;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 2));
    }
}
