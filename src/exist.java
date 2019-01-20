import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : exist.java
 * Time       : Create on 18-7-23
 * Location   : ../Home/JavaForLeeCode/exist.java
 * Function   : LeeCode No.79
 */
public class exist {

    private static boolean existResult1(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    private static boolean check(char[][] board, int i, int j, String word, int pos){
        if (pos == word.length())
            return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(pos))
            return false;
        board[i][j] = '*';
        boolean flag = check(board, i + 1, j, word, pos + 1)
                || check(board, i - 1, j, word, pos + 1)
                || check(board, i, j + 1, word, pos + 1)
                || check(board, i, j - 1, word, pos + 1);
        board[i][j]= word.charAt(pos);
        return flag;
    }

    // Must be consecutive
    private static boolean existResult(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0)
            return false;
        // flag[i][j]: false means vacant, true means occupied
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                if (board[i][j] == word.charAt(0) && find(board, flag, i, j, word, 0)) {
                    return true;
                } else {
                    for (boolean[] aFlag : flag)
                        Arrays.fill(aFlag, false);
                }
            }
        }
        return false;
    }

    private static boolean find(char[][] board, boolean[][] flag, int i, int j, String word, int index) {
        System.out.println(i + ", " + j + " index: " + index);
        if (index == word.length() - 1 && board[i][j] == word.charAt(index) && !flag[i][j]) {
            System.out.println("here");
            return true;
        }
        if (board[i][j] == word.charAt(index) && !flag[i][j]) {
            boolean[][] inFlag = flag.clone();
            inFlag[i][j] = true;
            if (i - 1 >= 0 && !inFlag[i - 1][j] && board[i - 1][j] == word.charAt(index + 1)) {
                if (find(board, inFlag, i - 1, j, word, index + 1))
                    return true;
            }
            if (i + 1 <= board.length - 1 && !inFlag[i + 1][j] && board[i + 1][j] == word.charAt(index + 1)) {
                if (find(board, inFlag, i + 1, j, word, index + 1))
                    return true;
            }
            if (j - 1 >= 0 && !inFlag[i][j - 1] && board[i][j - 1] == word.charAt(index + 1)) {
                if (find(board, inFlag, i, j - 1, word, index + 1))
                    return true;
            }
            if (j + 1 <= board[0].length - 1 && !inFlag[i][j + 1] && board[i][j + 1] == word.charAt(index + 1)) {
                if (find(board, inFlag, i, j + 1, word, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        System.out.println(existResult1(board, "ABCESEEEFS"));
    }
}
