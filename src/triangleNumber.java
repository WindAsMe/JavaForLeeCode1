import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : triangleNumber.java
 * Time       : Create on 18-6-30
 * Location   : ../Home/JavaForLeeCode/triangleNumber.java
 * Function   : LeeCode No.611
 */
public class triangleNumber {

    // The best proceeding
    public int triangleNumberResult3(int[] nums) {
        int count = 0, size = nums.length;
        Arrays.sort(nums);
        for (int i = size - 1; i >= 2; i--) {    // 先拿到第3条边
            int left = 0, right = i - 1;    // 前2条边
            while(left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += (right - left);    // 找到区间以后，就更新第2条边，构建新组合，并记录上个组合的总数
                    right--;
                }
                else {
                    left++;    // 调整第1条边
                }
            }
        }
        return count;
    }


    // 1. sort
    // 2. iteration the smallest 2 edges
    // 3. find the another edge
    private static int triangleNumberResult1(int[] nums) {
        if (nums.length < 3)
            return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                int k = find(nums[i] + nums[j], j, nums);
                if (k > j)
                    count += k - j - 1;
            }
        }
        return count;
    }

    // Binary find
    private static int find(int target, int index, int[] nums) {
        int left = index, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    // Brutal proceeding: TL
    private static int triangleNumberResult(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                for (int k = j + 1; k < nums.length; k ++) {
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i])
                        count ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(triangleNumberResult1(nums));
    }
}
