import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findWords.java
 * Time       : Create on 18-8-4
 * Location   : ../Home/JavaForLeeCode/findWords.java
 * Function   : LeeCode No.500
 */
public class findWords {

    private static String[] findWordsResult(String[] words) {
        if (words.length == 0)
            return words;
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);

        map.put('a',2);
        map.put('s',2);
        map.put('d',2);
        map.put('f',2);
        map.put('g',2);
        map.put('h',2);
        map.put('j',2);
        map.put('k',2);
        map.put('l',2);

        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);

        for (String word : words) {
            if (word.length() == 0 || word.length() == 1) {
                list.add(word);
                continue;
            }
            char s = word.charAt(0);
            if (s >= 'A' && s <= 'Z')
                s += 32;
            int flag = map.get(s);
            boolean mark = true;
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'A' && c <= 'Z')
                    c += 32;
                if (map.get(c) != flag) {
                    mark = false;
                    break;
                }
            }
            if (mark)
                list.add(word);
        }
        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    public static void main(String[] args) {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWordsResult(s)));
    }
}
