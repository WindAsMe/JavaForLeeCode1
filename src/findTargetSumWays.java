/**
 * Author     : WindAsMe
 * File       : findTargetSumWays.java
 * Time       : Create on 18-7-16
 * Location   : ../Home/JavaForLeeCode/findTargetSumWays.java
 * Function   : LeeCode No.494
 */
public class findTargetSumWays {

    private static int findTargetSumWaysResult(int[] nums, int S) {
        // total[0]: current value
        // total[1]: correspondence times
        int[] total = new int[]{0};
        dfs(nums, 0, total, 0, S);
        return total[0];
    }

    private static void dfs(int[] nums, int current, int[] total, int index, int S) {
        if (index == nums.length - 1) {
            if (current + nums[index] == S)
                total[0] ++;
            if (current - nums[index] == S)
                total[0] ++;
        } else {
            dfs(nums, current + nums[index], total, index + 1, S);
            dfs(nums, current - nums[index], total, index + 1, S);
        }
    }


    private static int findTargetSumWaysResult1(int[] nums, int S) {
        int sum = 0;
        for(int n:nums){
            sum +=n;
        }
        return sum < S || (sum + S) % 2 > 0 ? 0 : subsetsum(nums, (S + sum) >>> 1);
    }

    private static int subsetsum(int[] nums, int s){
        int dp[] = new int[s + 1];
        dp[0] = 1;
        for(int n : nums){
            for(int i = s; i >= n; i --){
                dp[i] = dp[i] + dp[i - n];
            }
        }
        return dp[s];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWaysResult(nums, 3));
    }
}
