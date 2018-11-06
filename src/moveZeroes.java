
/**
 * Author     : WindAsMe
 * File       : moveZeroes.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/moveZeroes.java
 * Function   : LeeCode No.283
 */
public class moveZeroes {

    private static void moveZeroesReusult(int[] nums) {
        int count = 0;
        for (int i = 0 ; i < nums.length - count ; i ++ ) {
            if (nums[i] == 0) {
                count ++;
                i = move(nums, i);
            }
        }
        for (int num : nums)
            System.out.print(num + " ");
    }

    private static int move(int[] nums, int index) {
        int i = index;
        for (; i < nums.length - 1 ; i ++ )
            nums[i] = nums[i + 1];
        nums[i] = 0;
        return index - 1;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,0,0,4,5,0,5};
        moveZeroesReusult(num);
    }
}
