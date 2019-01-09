import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : fourSum.java
 * Time       : Create on 18-7-17
 * Location   : ../Home/JavaForLeeCode/fourSum.java
 * Function   : LeeCode No.18
 */
public class fourSum {

    private static List<List<Integer>> fourSumResult(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int subtarget = target - nums[i] - nums[j];
                int m = j + 1, n = nums.length - 1;
                while (m < n){
                    if (nums[m] + nums[n] == subtarget) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[m] == nums[m + 1])
                            m++;
                        while (m < n && nums[n] == nums[n - 1])
                            n--;
                        m++;
                        n--;
                    } else if (nums[m] + nums[n] < subtarget)
                        m++;
                    else
                        n--;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0};
        List<List<Integer>> lists = fourSumResult(nums, 1);
        for (List<Integer> list : lists)
            System.out.println(list.toString());
    }
}
