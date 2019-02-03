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
        for (int i = 0; i < grid[0].length; i++)
            rowMax = Math.max(rowMax, grid[i][column]);
        for (int j = 0; j < grid[0].length; j++)
            columnMax = Math.max(columnMax, grid[row][j]);
        return Math.min(columnMax, rowMax) - grid[row][column];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {59, 88, 44},
                {3, 18, 38},
                {21, 26, 51}
        };
        System.out.println(maxIncreaseKeepingSkylineResult(grid));
    }
}
