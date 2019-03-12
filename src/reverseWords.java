/**
 * Author     : WindAsMe
 * File       : reverseWords.java
 * Time       : Create on 18-8-5
 * Location   : ../Home/JavaForLeeCode/reverseWords.java
 * Function   : LeeCode No.557
 */
public class reverseWords {

    private static String reverseWordsResult(String s) {
        s += " ";
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                end = i;
                sb.append(reverse(s.substring(start, end))).append(" ");
                start = end + 1;
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(reverse("leetcode"));
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWordsResult(s));
    }
}
