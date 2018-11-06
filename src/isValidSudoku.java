import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : isValidSudoku.java
 * Time       : Create on 18-7-20
 * Location   : ../Home/JavaForLeeCode/isValidSudoku.java
 * Function   : LeeCode No.36
 */
public class isValidSudoku {

    private static boolean isValidSudokuResult(char[][] board) {
        int i = 0;
        int j = 0;
        // index represents the occurrence or not
        boolean[] square = new boolean[10];
        boolean[] row = new boolean[10];
        boolean[] column = new boolean[10];
        for (int i1 = 0; i1 <= 6; i1 += 3) {
            for (int j1 = 0; j1 <=6; j1 += 3) {
                for (int r = i1; r < i1 + 3; r++) {
                    for (int c = j1; c < j1 + 3; c++) {
                        if (board[r][c] != '.' && !square[board[r][c] - '0'])
                            square[board[r][c] - '0'] = true;
                        else if (board[r][c] != '.' && square[board[r][c] - '0'])
                            return false;
                    }
                }
                Arrays.fill(square, false);
            }
        }
        while (i < 9) {
            System.out.println(i + " " + j);
            // the row and the board occurrence
            if (board[i][j] != '.') {
                row[board[i][j] - '0'] = true;
                column[board[i][j] - '0'] = true;
            }
            for (int temI = 0; temI < 9; temI++) {
                if (temI == i)
                    continue;
                if (board[temI][j] != '.') {
                    if (!column[board[temI][j] - '0']) {
                        column[board[temI][j] - '0'] = true;
                    } else {
                        return false;
                    }
                }
            }
            for (int temJ = 0; temJ < 9; temJ++) {
                if (j == temJ)
                    continue;
                if (board[i][temJ] != '.') {
                    if (!row[board[i][temJ] - '0']) {
                        row[board[i][temJ] - '0'] = true;
                    } else  {
                        return false;
                    }
                }
            }
            i++;
            j++;
            Arrays.fill(row, false);
            Arrays.fill(column, false);
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudokuResult(board));
    }
}
