/**
 * Author     : WindAsMe
 * File       : checkRecord.java
 * Time       : Create on 18-7-7
 * Location   : ../Home/JavaForLeeCode/checkRecord.java
 * Function   : LeeCode No.551
 */
public class checkRecord {

    private static boolean checkRecordResult(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countL = 0;
                countA ++;
                if (countA > 1)
                    return false;
            } else if (s.charAt(i) == 'L') {
                countL ++;
                if (countL > 2)
                    return false;
            } else
                countL = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "LALL";
        System.out.println(checkRecordResult(s));
    }
}
