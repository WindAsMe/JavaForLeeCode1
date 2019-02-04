/**
 * Author     : WindAsMe
 * File       : convert.java
 * Time       : Create on 18-7-20
 * Location   : ../Home/JavaForLeeCode/convert.java
 * Function   : LeeCode No.6
 */
public class convert {

    private static String convertResult(String s, int numRows) {
        if ( numRows <= 1 || s.length() <= 2 || s.length() <= numRows)
            return s;
        StringBuilder ans = new StringBuilder();
        int n = s.length() , sep = 2 * ( numRows - 1 ) ;
        for ( int i = 0; i < numRows; i++ ) {
            for ( int j = i ; j < n ; j += sep ) {
                ans.append(s.charAt(j));
                if ( i != 0 && i != numRows - 1 && sep + j - 2 * i < n )
                    ans.append(s.charAt(sep + j - 2 * i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDq";
        int numRows = 2;
        System.out.println(convertResult(s, numRows));
    }
}
