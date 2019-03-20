/**
 * Author     : WindAsMe
 * File       : lemonadeChange.java
 * Time       : Create on 18-7-3
 * Location   : ../Home/JavaForLeeCode/lemonadeChange.java
 * Function   : LeeCode No.860
 */
public class lemonadeChange {

    private static boolean lemonadeChangeResult(int[] bills) {
        int dollor_5 = 0;
        int dollor_10 = 0;
        for (int bill : bills) {
            if (bill == 5)
                dollor_5++;
            if (bill == 10) {
                if (dollor_5 == 0)
                    return false;
                else {
                    dollor_5--;
                    dollor_10++;
                }
            }
            if (bill == 20) {
                if (dollor_10 - 1 >= 0 && dollor_5 - 1 >= 0) {
                    dollor_10 --;
                    dollor_5 --;
                } else if (dollor_5 - 3 >= 0)
                    dollor_5 -= 3;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {10, 10};
        System.out.println(lemonadeChangeResult(bills));
    }
}
