import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : solveNQueens.java
 * Time       : Create on 18-7-22
 * Location   : ../Home/JavaForLeeCode/solveNQueens.java
 * Function   : LeeCode No.51
 */
public class solveNQueens {

    private static List<List<String>> solveNQueensResult(int n) {
        List<List<String>> list= new ArrayList<>();
        helper(0, 0, n, new int[n], list);
        return list;
    }

    private static void helper(int row, int col, int n, int[] column, List<List<String>> l){
        if (row == n){
            List<String> sub= new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder sb= new StringBuilder();
                for (int k = 0; k < column[j]; k++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int k = column[j]+1; k < n; k++) {
                    sb.append(".");
                }
                sub.add(sb.toString());
            }
            l.add(sub);
        }
        else{
            for (int i = col; i < n; i++) {
                column[row]= i;
                boolean f = true;
                for (int r = row - 1, lc = i - 1, rc = i + 1; r >= 0 ; r--, lc--, rc++ ) {
                    if (column[r] == i || column[r] ==lc || column[r] == rc)
                        f= false;
                }
                if (f)
                    helper(row + 1, 0, n, column, l);
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> lists = solveNQueensResult(4);
        for (List<String> list : lists)
            System.out.println(list.toString());
    }
}
