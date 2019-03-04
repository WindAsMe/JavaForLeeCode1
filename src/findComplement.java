/**
 * Author     : WindAsMe
 * File       : findComplement.java
 * Time       : Create on 18-6-19
 * Location   : ../Home/JavaForLeeCode/findComplement.java
 * Function   : LeeCode No.476
 */
public class findComplement {

    private static int findComplementResult(int num) {
        int sum = 0;
        int n = 0;
        int Div = -1;
        int Rem;
        while (Div != 0) {
            Div = num / 2;
            Rem = num % 2;
            num = Div;
            sum += (1 - Rem) * Math.pow(2, n);
            n++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplementResult(num));
    }
}
