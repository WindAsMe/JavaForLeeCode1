/**
 * Author     : WindAsMe
 * File       : hammingWeight.java
 * Time       : Create on 18-7-26
 * Location   : ../Home/JavaForLeeCode/hammingWeight.java
 * Function   : LeeCode No.191
 */
public class hammingWeight {

    // you need to treat n as an unsigned value
    private static int hammingWeightResult(int n) {
        if(n == 0)
            return 0;
        int i = 0;
        while(n != 0){
            n = n & (n - 1);
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeightResult(11));
    }
}
