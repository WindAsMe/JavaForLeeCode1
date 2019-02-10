/**
 * Author     : WindAsMe
 * File       : findMaxAverage.java
 * Time       : Create on 18-6-30
 * Location   : ../Home/JavaForLeeCode/findMaxAverage.java
 * Function   : LeeCode No.643
 */
public class findMaxAverage {

    // Comparing with slid window.
    private static double findMaxAverageResult1(int[] nums, int k) {
        int maxSum, sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        maxSum = sum;
        for (int l = 0, r = k; r < nums.length; l++, r++) {
            sum += nums[r] - nums[l];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }

    // Brutal proceeding: TL
    private static double findMaxAverageResult(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i ++) {
            double current = nums[i];
            int index = i + 1;
            while (index < i + k) {
                current += nums[index];
                index ++;
            }
            max = Math.max(max, current / k);
            //System.out.println("cir: " + max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverageResult1(nums, k));
    }
}
