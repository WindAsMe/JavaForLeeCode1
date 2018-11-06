/**
 * Author     : WindAsMe
 * File       : findMaxConsecutiveOnes.java
 * Time       : Create on 18-6-18
 * Location   : ../Home/JavaForLeeCode/findMaxConsecutiveOnes.java
 * Function   : LeeCode No.485
 */
public class findMaxConsecutiveOnes {

    private static int findMaxConsecutiveOnesResult(int[] nums) {
        int currentMax = 0;
        int totalMax = 0;
        for (int num : nums) {
            if (num == 1) {
                currentMax++;
            } else {
                totalMax = currentMax > totalMax ? currentMax : totalMax;
                currentMax = 0;
            }
        }
        return currentMax > totalMax ? currentMax : totalMax;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(findMaxConsecutiveOnesResult(nums));
    }
}
