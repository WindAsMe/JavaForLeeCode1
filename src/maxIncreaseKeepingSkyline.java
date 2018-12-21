/**
 * Author     : WindAsMe
 * File       : maxIncreaseKeepingSkyline.java
 * Time       : Create on 18-12-21
 * Location   : ../Home/JavaForLeetCode/maxIncreaseKeepingSkyline.java
 * Function   : LeetCode No.807
 */
public class maxIncreaseKeepingSkyline {

    private static int maxIncreaseKeepingSkylineResult(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                ans += getAugmentation(grid, i, j);
        }
        return ans;
    }

    private static int getAugmentation(int[][] grid, int row, int column) {
        int rowMax = 0;
        int columnMax = 0;
        for (int i = 0; i < row; i++)
            rowMax = Math.max(rowMax, grid[i][column]);
        for (int j = 0; j < column; j++)
            columnMax = Math.max(columnMax, grid[column][j]);
        return Math.min(columnMax, rowMax);
    }

    public static void main(String[] args) {

    }
}
