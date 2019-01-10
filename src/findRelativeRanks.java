import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findRelativeRanks.java
 * Time       : Create on 18-6-22
 * Location   : ../Home/JavaForLeeCode/findRelativeRanks.java
 * Function   : LeeCode No.506
 */
public class findRelativeRanks {

    // Relate the index and value
    // Sort depending value
    // Set the String[index] = corresponding reward
    private static String[] findRelativeRanksResult(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i ++) {
            // temp save the value and index
            int[] temp = new int[2];
            temp[0] = nums[i];
            temp[1] = i;
            list.add(temp);
        }
        list.sort((o1, o2) -> o2[0] - o1[0]);
        String[] ans = new String[nums.length];
        for (int i = 0 ; i < nums.length ; i ++ ) {
            if (i == 0) {
                ans[list.get(0)[1]] = "Gold Medal";
            } else if (i == 1) {
                ans[list.get(1)[1]] = "Silver Medal";
            } else if (i == 2) {
                ans[list.get(2)[1]] = "Bronze Medal";
            } else {
                ans[list.get(i)[1]] = String.valueOf(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {7,3};
        String[] ans = findRelativeRanksResult(num);
        System.out.println(Arrays.toString(ans));
    }
}
