import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : threeSum.java
 * Time       : Create on 18-7-8
 * Location   : ../Home/JavaForLeeCode/threeSum.java
 * Function   : LeeCode No.15
 */
public class threeSum {

    private static List<List<Integer>> threeSumResult(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0 || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;


            int sum = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);

                    while (left < right && nums[left++] == nums[left]) {}
                    while (left < right && nums[right--] == nums[right]) {}

                } else if (nums[left] + nums[right] < sum) {
                    while (left < right && nums[left++] == nums[left]) {}

                } else {
                    while (left < right && nums[right--] == nums[right]) {}
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,-1,-4};
        List<List<Integer>> lists = threeSumResult(nums);
        for (List<Integer> list : lists)
            System.out.println(list.toString());
    }
}
