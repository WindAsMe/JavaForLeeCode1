import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : wordBreak.java
 * Time       : Create on 18-6-24
 * Location   : ../Home/JavaForLeeCode/wordBreak.java
 * Function   : LeeCode No.139
 */
public class wordBreak {

    private static boolean wordBreakResult(String s, List<String> wordDict) {
        if (null == s || "".equals(s))
            return true;
        boolean[] dp = new boolean[s.length()];
        dp[0] = wordDict.contains(s.substring(0, 1));
        for(int i = 1; i < s.length(); i++) {
            // If index from 0 to i
            // word can be consisted
            if (wordDict.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            } else {
                // From 0 to i
                // If word can be consisted
                for(int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        System.out.println(wordBreakResult("aaaaaaa", list));
    }

}
