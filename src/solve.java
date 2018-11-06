import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : solve.java
 * Time       : Create on 18-7-5
 * Location   : ../Home/JavaForLeeCode/solve.java
 * Function   : LeeCode No.130
 */
public class solve {

    private static void solveResult(char[][] board) {
        if (board.length == 0) return;
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i ++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            if (board[i][col - 1] == 'O')
                dfs(board, i, col - 1);
        }

        for (int i = 1; i < col - 1; i ++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[row - 1][i] == 'O')
                dfs(board,row - 1, i);
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(char[][] board, int m, int n) {
        if (board[m][n] != 'O') return;
        board[m][n] = '1';
        if (m < board.length - 2)
            dfs(board, m + 1, n);
        if (m > 1)
            dfs(board, m - 1, n);
        if (n < board[0].length - 2)
            dfs(board, m, n + 1);
        if (n > 1)
            dfs(board, m, n - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'X', 'X'},
                        };
        solveResult(board);
        for (char[] c : board)
            System.out.println(Arrays.toString(c));
    }
}
