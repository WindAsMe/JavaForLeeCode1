import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : letterCombinations.java
 * Time       : Create on 18-7-10
 * Location   : ../Home/JavaForLeeCode/letterCombinations.java
 * Function   : LeeCode No.17
 */
public class letterCombinations {

    private static List<String> letterCombinationsResult(String digits) {
        if ("".equals(digits))
            return new ArrayList<>();
        // Simulate as a HashMap
        // Directly corresponding
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        // Skip the '1'
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (c != '1')
                temp.append(c);
        }
        recursion(new StringBuilder(), temp, list, map);
        return list;
    }

    private static void recursion(StringBuilder wait, StringBuilder s, List<String> list, String[] map) {
        if (wait.length() > s.length())
            return;
        if (wait.length() == s.length()) {
            list.add(wait.toString());
            return;
        }

        // Get the map's String
        int len = wait.length();
        int index = s.charAt(len) - '0';
        String add = map[index];
        for (int i = 0; i < add.length(); i++) {
            recursion(wait.append(add.charAt(i)), s, list, map);
            wait.deleteCharAt(wait.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "";
        System.out.println(letterCombinationsResult(digits).toString());
    }
}
