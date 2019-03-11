import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : gameOfLife.java
 * Time       : Create on 18-7-16
 * Location   : ../Home/JavaForLeeCode/gameOfLife.java
 * Function   : LeeCode No.289
 */
public class gameOfLife {

    private static void gameOfLifeResult(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        int[][] helper = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            System.arraycopy(board[i], 0, helper[i], 0, board[0].length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int sum = 0;
                // The order:
                // Left
                if (j != 0 && helper[i][j - 1] == 1)
                    sum++;
                // LeftTop
                if (j != 0 && i != 0 && helper[i - 1][j - 1] == 1)
                    sum++;
                // Top
                if (i != 0 && helper[i - 1][j] == 1)
                    sum++;
                // RightTop
                if (i != 0 && j < board[0].length - 1 && helper[i - 1][j + 1] == 1)
                    sum++;
                // Right
                if (j < board[0].length - 1 && helper[i][j + 1] == 1)
                    sum++;
                // RightButton
                if (i < board.length - 1 && j < board[0].length - 1 && helper[i + 1][j + 1] == 1)
                    sum++;
                // Button
                if (i < board.length - 1 && helper[i + 1][j] == 1)
                    sum++;
                // LeftButton
                if (i < board.length - 1 && j != 0 && helper[i + 1][j - 1] == 1)
                    sum++;
                System.out.println("sum: "+ sum);
                if (board[i][j] == 1) {
                    if (sum < 2)
                        board[i][j] = 0;
                    if (sum > 3)
                        board[i][j] = 0;
                } else {
                    if (sum == 3)
                        board[i][j] = 1;
                }
            }
        }
        for (int[] ans : board)
            System.out.println(Arrays.toString(ans));
    }


    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLifeResult(nums);
    }
}
