/**
 * Author     : WindAsMe
 * File       : NumArray.java
 * Time       : Create on 18-6-10
 * Location   : ../Home/JavaForLeeCode/NumArray.java
 * Function   : LeeCode No.303
 */
public class NumArray {

    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++)
            sum += nums[k];
        return sum;
    }
}
