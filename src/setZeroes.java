/**
 * Author     : WindAsMe
 * File       : setZeroes.java
 * Time       : Create on 18-6-5
 * Location   : ../Home/JavaForLeeCode/setZeroes.java
 * Function   : LeeCode No.73
 */
public class setZeroes {

    private static void setZeroesResult(int[][] matrix) {
        //[
        //  [0,1,2,0],
        //  [3,4,5,2],
        //  [1,3,1,5]
        //]
        // m = 3(row)   n = 4(column)

        int m = matrix.length;
        int n = matrix[0].length;
        // mValue: column value
        // nValue: row value
        int[] mValue = new int[m * n];
        int[] nValue = new int[m * n];
        int mValueCurrentLength = 0;
        int nValueCurrentLength = 0;
        for (int i = 0 ; i < n ; i++ ) {
            for (int j = 0 ; j < m ; j++ ) {
                 System.out.println("i:" + i + " j:" + j);
                if (matrix[j][i] == 0) {
                    if (!isExist(mValue, mValueCurrentLength, i)) {
                        if (!isExist(nValue, nValueCurrentLength, j)) {
                            mValue[mValueCurrentLength] = i;
                            mValueCurrentLength ++;
                            nValue[nValueCurrentLength] = j;
                            nValueCurrentLength ++;
                        } else {
                            mValue[mValueCurrentLength] = i;
                            mValueCurrentLength ++;
                        }
                    } else {
                        if (!isExist(nValue, nValueCurrentLength, j)) {
                            nValue[nValueCurrentLength] = j;
                            nValueCurrentLength++;
                        }
                    }
                }
            }
        }

        //System.out.println("length: " + mValueCurrentLength + " " + nValueCurrentLength);

        for (int i = 0 ; i < mValueCurrentLength ; i ++ ) {
            for (int j = 0 ; j < m ; j ++ )
                matrix[j][mValue[i]] = 0;
        }

        for (int i = 0 ; i < nValueCurrentLength ; i ++ ) {
            for (int j = 0 ; j < n ; j ++ )
                matrix[nValue[i]][j] = 0;
        }
        printMatrix(matrix);
    }

    private static boolean isExist(int[] value, int currentLength, int temp) {
        for (int i = 0 ; i < currentLength ; i ++ ) {
            if (temp == value[i])
                return true;
        }
        return false;
    }
    // True means find
    // False means missed
//    private static boolean isExist(int[] mValue, int[] nValue, int mValueCurrentLength, int nValueCurrentLength, int row, int column) {
//        for (int i = 0 ; i < mValueCurrentLength ; i ++) {
//            if (column == mValue[i]) {
//                return true;
//            }
//        }
//
//        for (int i = 0 ; i < nValueCurrentLength ; i ++) {
//            if (row == nValue[i]) {
//                return true;
//            }
//        }
//        return false;
//    }

//    private static void printToZero(int[][] matrix, int row, int column) {
//        for (int i = 0 ; i < matrix[0].length ; i ++ )
//            matrix[row][i] = 0;
//        for (int i = 0 ; i < matrix.length ; i ++ )
//            matrix[i][column] = 0;
//    }


    private static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {8,7,5,3,6,0,8,8,0}
        };
        setZeroesResult(matrix);
    }
}
