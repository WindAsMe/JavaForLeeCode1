import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : rotateMatrix.java
 * Time       : Create on 18-7-9
 * Location   : ../Home/JavaForLeeCode/rotateMatrix.java
 * Function   : LeeCode No.48
 */
public class rotateMatrix {

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i ++){
            // The rotation reflection:
            // (i,j)->(x,y)： x = n - j - 1, y = i;
            for(int j = i; j < n - i - 1; j ++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }

        for (int[] a : matrix)
            System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };
        rotate(matrix);
    }
}
