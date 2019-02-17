import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : matrixReshape.java
 * Time       : Create on 18-6-26
 * Location   : ../Home/JavaForLeeCode/matrixReshape.java
 * Function   : LeeCode No.566
 */
public class matrixReshape {

    private static int[][] matrixReshapeResult(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r * c)
            return nums;
        else {
            int[][] ans = new int[r][c];
            // position of primary array
            int row = 0;
            int colomn = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans[i][j] = nums[row][colomn];
                    colomn++;
                    row += colomn / nums[0].length;
                    colomn %= nums[0].length;
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        int[][] nums = {{}, {}};
        int[][] ans = matrixReshapeResult(nums, 1, 3);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
