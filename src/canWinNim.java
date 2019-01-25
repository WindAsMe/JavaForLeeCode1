/**
 * Author     : WindAsMe
 * File       : canWinNim.java
 * Time       : Create on 18-6-10
 * Location   : ../Home/JavaForLeeCode/canWinNim.java
 * Function   : LeeCode No.292
 */
public class canWinNim {

    private static boolean canWinNimResult(int n) {
        return (n % 4) == 0 ;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(canWinNimResult(n));
    }
}
