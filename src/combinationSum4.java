
/**
 * Author     : WindAsMe
 * File       : combinationSum4.java
 * Time       : Create on 18-6-24
 * Location   : ../Home/JavaForLeeCode/combinationSum4.java
 * Function   : LeeCode No.377
 */
public class combinationSum4 {

    private static int combinationSum4Result(int[] nums, int target) {
        int[]dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i ++ ) {
            for (int num : nums)
                if (i + num <= target)
                    dp[i + num] += dp[i];
        }
        return dp[target];
    }

    // Calculate the all feasibility
//    private static int combinationSum4Result(int[] nums, int target) {
//        Arrays.sort(nums);
//        // record the current value
//        int count = 0;
//        int index;
//        for (int num : nums) {
//            index = 0;
//            int currentValue = 0;
//            Stack<Integer> stack = new Stack<>();
//            currentValue += num;
//            stack.push(num);
//            while (currentValue <= target && index < nums.length && !stack.empty()) {
//                if (currentValue + nums[index] == target) {
//                    count++;
//                    stack.push(nums[index]);
//                    System.out.println("in equality:" + stack.toString());
//                    stack.pop();
//                    currentValue -= stack.pop();
//                    index ++;
//                } else if (currentValue + nums[index] < target) {
//                    stack.push(nums[index]);
//                    currentValue += nums[index];
//                    index = 0;
//                } else {
//                    currentValue -= stack.pop();
//                }
//                //System.out.println("in circulation:" + stack.toString() + " " + currentValue);
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4Result(nums,4));
    }
}
