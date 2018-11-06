/**
 * Author     : WindAsMe
 * File       : search.java
 * Time       : Create on 18-7-15
 * Location   : ../Home/JavaForLeeCode/search.java
 * Function   : LeeCode No.33
 */
public class search {

    private static int searchResult(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int center = (start + end) / 2;
            if (nums[center] == target)
                return center;
            if (nums[center] >= nums[start]){
                if (target < nums[center] && target >= nums[start])
                    end = center - 1;
                else
                    start = center + 1;
            }
            if (nums[center] <= nums[end]){
                if (target > nums[center] && target <= nums[end])
                    start = center+1;
                else
                    end = center-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {5,6,7,8,9,1};
        System.out.println(searchResult(nums, 7));
    }
}
