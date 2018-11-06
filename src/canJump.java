/**
 * Author     : WindAsMe
 * File       : canJump.java
 * Time       : Create on 18-7-10
 * Location   : ../Home/JavaForLeeCode/canJump.java
 * Function   : LeeCode No.55
 */
public class canJump {

    private static boolean canJumpResult(int[] nums) {
        int ans = 0;
        // Continuing to update the max value
        for(int i = 0; i <= ans; i ++) {
            ans = Math.max(ans, nums[i] + i);
            if(ans >= nums.length - 1)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJumpResult(nums));
    }
}
