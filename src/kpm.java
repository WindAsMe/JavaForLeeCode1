import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : kpm.java
 * Time       : Create on 19-6-12
 * Location   : ../Home/JavaForLeetCode/kpm.java
 */
public class kpm {

    private static List<Integer> kpmResult(String word, String sentence) {
        List<Integer> list = new ArrayList<>();
        int[] next = help(word);
        return list;
    }

    // kmp set next array
    private static int[] help(String word) {
        int[] ans = new int[word.length()];
        ans[0] = 0;
        for (int i = 1; i < word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (word.charAt(i) == word.charAt(j))
                    ans[i] = j + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String word = "ABCDABD";
        String sentence = "BBC ABCDAB ABCDABCDABDE";
        System.out.println(Arrays.toString(help(word)));
    }
}
