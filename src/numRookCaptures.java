/**
 * Author     : WindAsMe
 * File       : numRookCaptures.java
 * Time       : Create on 19-4-23
 * Location   : ../Home/JavaForLeetCode/numRookCaptures.java
 * Function   : LeetCode No.999
 */
public class numRookCaptures {

    private static int numRookCapturesResult(char[][] board) {
        int sum = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    column = j;
                    break;
                }
            }
        }

        for (int i = row; i < 8; i++) {
            if (board[i][column] == 'B')
                break;
            else if (board[i][column] == 'p') {
                sum++;
                break;
            }
        }

        for (int i = row; i >= 0; i--) {
            if (board[i][column] == 'B')
                break;
            else if (board[i][column] == 'p') {
                sum++;
                break;
            }
        }

        for (int i = column; i < 8; i++) {
            if (board[row][i] == 'B')
                break;
            else if (board[row][i] == 'p') {
                sum++;
                break;
            }
        }

        for (int i = column; i >= 0; i--) {
            if (board[row][i] == 'B')
                break;
            else if (board[row][i] == 'p') {
                sum++;
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
