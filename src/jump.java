import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : jump.java
 * Time       : Create on 18-7-21
 * Location   : ../Home/JavaForLeeCode/jump.java
 * Function   : LeeCode No.45
 */
public class jump {

    private static int jumpResult(int[] nums) {
        if (nums.length <= 1)
            return 0;
        // index: array in choice
        // start and end
        int[] index = new int[]{0, nums[0]};
        // current: can approach the largest distance
        // current[0]: max corresponding index
        // current[1]: distance
        int[] current = new int[2];
        int time = 1;
        while (index[1] < nums.length - 1) {
            for (int i = index[0]; i <= index[1]; i++) {
                if (i + nums[i] > current[1]) {
                    current[0] = i;
                    current[1] = i + nums[i];
                }
            }
            System.out.println("index: " + Arrays.toString(index));
            System.out.println("current: " + Arrays.toString(current));
            time++;
            index[0] = current[0];
            index[1] = current[1];
            Arrays.fill(current, 0);
        }
        return time;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1, 1,4,1,2,5};
        System.out.println(jumpResult(nums));
    }
}
