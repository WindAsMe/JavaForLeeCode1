import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : permuteUnique.java
 * Time       : Create on 18-7-22
 * Location   : ../Home/JavaForLeeCode/permuteUnique.java
 * Function   : LeeCode No.
 */
public class permuteUnique {

    private static List<List<Integer>> permuteUniqueResult(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        helper(result, nums, new ArrayList<>(), 0, new int[nums.length]);
        return result;
    }

    // Utilize the pos to represent the usage. Array of boolean is more efficient
    private static void helper(List<List<Integer>> result, int[] nums, List<Integer> ans, int num, int[] pos){
        if (num == nums.length) {
            result.add(new ArrayList<>(ans));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (pos[i] == 0 ) {
                ans.add(nums[i]);
                pos[i] = 1;
                helper(result, nums, ans, num + 1, pos);
                pos[i] = 0;
                ans.remove(num);
                while(i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        List<List<Integer>> lists = permuteUniqueResult(nums);
        for (List<Integer> list : lists)
            System.out.println(list.toString());
    }
}
