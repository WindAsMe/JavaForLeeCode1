/**
 * Author     : WindAsMe
 * File       : minMoves.java
 * Time       : Create on 18-6-19
 * Location   : ../Home/JavaForLeeCode/minMoves.java
 * Function   : LeeCode No.453
 */
public class minMoves {

    // Put nums.length() - 1 elements add 1
    // Equal the one element minus 1
    // So need all need to descent to the MIN
    private static int minMovesResult(int[] nums) {
        if (nums.length <= 1)
            return 0;
        else {
            int min = nums[0];
            int count = 0;
            for (int num : nums)
                min = min > num ? num : min;

            for (int num : nums)
                count += num - min;
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMovesResult(nums));
    }
}
