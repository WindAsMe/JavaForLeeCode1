import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findAnagrams.java
 * Time       : Create on 18-8-20
 * Location   : ../Home/JavaForLeeCode/findAnagrams.java
 * Function   : LeeCode No.438
 */
public class findAnagrams {

    private static List<Integer> findAnagramsResult(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int[] helper = new int[26];
        for (char c : pChar)
            helper[c - 'a']++;
        // System.out.println(Arrays.toString(helper));
        for (int i = 0; i <= sChar.length - pChar.length; i++) {
            // s has the same element
            if (helper[sChar[i] - 'a'] != 0) {
                int[] profile = new int[26];
                profile[sChar[i] - 'a']++;
                for (int j = 1; j < p.length(); j++) {
                    profile[sChar[i + j] - 'a']++;
                    if (profile[sChar[i + j] - 'a'] > helper[sChar[i + j] - 'a'])
                        break;
                }
                if (Arrays.equals(profile, helper))
                    list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagramsResult( "abab", "ab"));
    }
}
