/**
 * Author     : WindAsMe
 * File       : detectCapitalUse.java
 * Time       : Create on 18-6-22
 * Location   : ../Home/JavaForLeeCode/detectCapitalUse.java
 * Function   : LeeCode No.520
 */
public class detectCapitalUse {

    private static boolean detectCapitalUseResult(String word) {
        if (word.length() == 1)
            return true;
        char temp = word.charAt(0);
        if (temp >= 'a') {
            for (int i = 1; i < word.length(); i++ ) {
                if (word.charAt(i) <= 'Z')
                    return false;
            }
            return true;
        // First word is higher
        } else {
            char temp1 = word.charAt(1);
            // Second word is lower
            if (temp1 >= 'a') {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) <= 'Z')
                        return false;
                }
                return true;

            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 'a')
                        return false;
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        String word = "Uc";
        System.out.println(detectCapitalUseResult(word));
    }
}
