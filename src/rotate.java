/**
 * Author     : WindAsMe
 * File       : rotate.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/rotate.java
 * Function   : LeeCode No.189
 */
public class rotate {

    private static void rotateResult(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int[] copy = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i ++ ) {
            copy[(i + k) % (nums.length )] = nums[i];
        }
        System.arraycopy(copy, 0, nums, 0, nums.length);
        for (int num : copy) {
            System.out.print(num + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        rotateResult(arr, 2);
    }
}
