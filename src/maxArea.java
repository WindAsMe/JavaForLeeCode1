/**
 * Author     : WindAsMe
 * File       : maxArea.java
 * Time       : Create on 18-7-20
 * Location   : ../Home/JavaForLeeCode/maxArea.java
 * Function   : LeeCode No.11
 */
public class maxArea {

    private static int maxAreaResult1(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r])
                ++l;
            else
                --r;
        }
        return res;
    }

    // Brutal Proceeding
    private static int maxAreaReuslt(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++)
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,2,1,5,5};
        System.out.println(maxAreaResult1(nums));
    }
}
