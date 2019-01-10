import java.util.*;

/**
 * Author     : WindAsMe
 * File       : groupAnagrams.java
 * Time       : Create on 18-7-22
 * Location   : ../Home/JavaForLeeCode/groupAnagrams.java
 * Function   : LeeCode No.49
 */
public class groupAnagrams {

    // Use map and list together
    private static List<List<String>> groupAnagramsResult2(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String s1 = Arrays.toString(c);
            if (map.get(s1) == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s1, list);
            } else {
                List<String> list = map.get(s1);
                list.add(s);
                map.put(s1, list);
            }
        }
        for (Map.Entry<String, List<String>> m : map.entrySet())
            lists.add(m.getValue());
        return lists;
    }


    // Use Array sort to instead of Summary: TL
    // String trans to char[]
    private static List<List<String>> groupAnagramsResult1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == null)
                    continue;
                char[] c1 = strs[j].toCharArray();
                Arrays.sort(c1);
                if (Arrays.equals(c, c1)) {
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            lists.add(list);
        }
        return lists;
    }


    // Brutal: TL
    private static List<List<String>> groupAnagramsResult(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            if ("".equals(strs[i])) {
                List<String> list  = new ArrayList<>();
                list.add("");
                strs[i] = null;
                for (int j = i + 1; j < strs.length; j++) {
                    if ("".equals(strs[j])) {
                        list.add("");
                        strs[j] = null;
                    }
                }
                lists.add(list);
                continue;
            }
            char[] c = strs[i].toCharArray();
            // System.out.println(Arrays.toString(c));
            Map<Character, Integer> map = new HashMap<>();
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (char aC : c) {
                map.merge(aC, 1, (a, b) -> a + b);
            }
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == null) {
                    continue;
                }
                char[] c1 = strs[j].toCharArray();
                Map<Character, Integer> map1 = new HashMap<>();
                for (char aC1 : c1) {
                    map1.merge(aC1, 1, (a, b) -> a + b);
                }
                if (map.equals(map1)) {
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            lists.add(list);
        }
        // System.out.println(Arrays.toString(strs));
        return lists;
    }


    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat", "atn"};
        List<List<String>> lists = groupAnagramsResult2(s);
        for (List<String> list : lists)
            System.out.println(list.toString());
    }
}
