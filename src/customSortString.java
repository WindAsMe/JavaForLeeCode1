import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : customSortString.java
 * Time       : Create on 18-12-25
 * Location   : ../Home/JavaForLeetCode/customSortString.java
 * Function   : LeetCode No.791
 */
public class customSortString {

    private static String customSortStringResult(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (char c : s) {
            if (map.containsKey(c)) {
                for (int i = 0; i < map.get(c); i++)
                    builder.append(c);
                map.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++)
                builder.append(entry.getKey());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String S = "cba";
        String T = "abcdq";
        System.out.println(customSortStringResult(S, T));
    }
}
