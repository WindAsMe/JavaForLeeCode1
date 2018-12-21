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
        for (int[] aGrid : grid)
            rowMax = Math.max(rowMax, aGrid[column]);
        for (int j = 0; j < grid[0].length; j++)
            columnMax = Math.max(columnMax, grid[column][j]);
        return Math.min(columnMax, rowMax) - grid[row][column];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        };
        System.out.println(maxIncreaseKeepingSkylineResult(grid));
    }
}
