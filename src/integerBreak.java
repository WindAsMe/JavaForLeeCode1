/**
 * Author     : WindAsMe
 * File       : integerBreak.java
 * Time       : Create on 18-6-17
 * Location   : ../Home/JavaForLeeCode/integerBreak.java
 * Function   : LeeCode No.343
 */
public class integerBreak {

    private static int integerBreakResult(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        // Divide
        int k1 = n % 3;
        int k2 = n / 3;
        if(k1 == 1)
            k2 --;
        int sum = 1;
        for(int i = 0 ; i < k2 ; i++)
            sum *= 3;
        if(k1 == 1)
            return sum * 4;
        else if(k1 == 2)
            return sum * 2;
        else
            return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreakResult(n));
    }
}
