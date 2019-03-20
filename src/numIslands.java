/**
 * Author     : WindAsMe
 * File       : numIslands.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/numIslands.java
 * Function   : LeeCode No.200
 */
public class numIslands {

    private static int numIslandsResult(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        else {
            int count = 0;
            for (int i = 0 ; i < grid.length; i ++ ) {
                for (int j = 0 ; j < grid[0].length ; j ++ ) {
                    if (grid[i][j] == '1') {
                        count ++;
                        paint(grid, i, j);
                    }
                }
            }
            return count;
        }
    }

    private static void paint(char[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length || i < 0 || j < 0)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            paint(grid, i - 1, j);
            paint(grid, i, j - 1);
            paint(grid, i + 1, j);
            paint(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
                {'1','1','1', '0','1'},
//                {'0','1','0'},
//                {'1','1','1'}
        };
        System.out.println(numIslandsResult(grid));
    }
}
