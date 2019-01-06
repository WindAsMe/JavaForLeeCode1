import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : imageSmoother.java
 * Time       : Create on 18-7-2
 * Location   : ../Home/JavaForLeeCode/imageSmoother.java
 * Function   : LeeCode No.661
 */
public class imageSmoother {

    private static int[][] imageSmootherResult(int[][] M) {
        int count;
        int sum;
        if(M != null && M.length != 0) {
            int row = M.length;
            int col = M[0].length;
            int[][] res = new int[row][col];
            for(int i = 0; i < row; i ++) {
                for(int j = 0; j < M[i].length; j ++) {
                    sum = 0;
                    count = 9;
                    for(int R = i - 1; R < i + 2; R ++) {
                        for(int C = j - 1; C < j + 2; C ++) {
                            if(R < 0 || R > row - 1)
                                count--;
                            else {
                                col = M[R].length;
                                if(C < 0 || C > col - 1)
                                    count --;
                                else
                                    sum += M[R][C];

                            }
                        }
                        res[i][j] = sum/count;
                    }
                }
            }
            return res;
        }
        return M;
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,1},
                {1,0,1},
                {1,1,1}};
        int[][] ans = imageSmootherResult(M);
        for (int[] a : ans)
            System.out.println(Arrays.toString(a));
    }
}
