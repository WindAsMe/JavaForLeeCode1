import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : sortColors.java
 * Time       : Create on 18-6-5
 * Location   : ../Home/JavaForLeeCode/sortColors.java
 * Function   : LeeCode No.75
 */
public class sortColors {

    private static void sortColorsResult(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,0,0,2,1};
        sortColorsResult(nums);
        for (int i = 0 ; i < nums.length ; i ++ ) {
            System.out.print(nums[i] + " ");
        }
    }
}
