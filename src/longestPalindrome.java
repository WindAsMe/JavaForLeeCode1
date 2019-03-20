/**
 * Author     : WindAsMe
 * File       : longestPalindrome.java
 * Time       : Create on 18-7-30
 * Location   : ../Home/JavaForLeeCode/longestPalindrome.java
 * Function   : LeeCode No.409
 */
public class longestPalindrome {

    private static int longestPalindromeResult(String s) {
        int max = 0;
        boolean flag = false;
        int[] helper = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a >= 'a' && a <= 'z')
                helper[a - 'G']++;
            else
                helper[a - 'A']++;
        }
        for (int a : helper) {
            if (a % 2 == 0)
                max += a;
            else {
                max += a - 1;
                flag = true;
            }
        }
        if (flag)
            return max + 1;
        else
            return max;
    }


    public static void main(String[] args) {
        String s = "AsdfA";
        System.out.println(longestPalindromeResult(s));
    }
}
