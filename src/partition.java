import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : partition.java
 * Time       : Create on 18-7-26
 * Location   : ../Home/JavaForLeeCode/partition.java
 * Function   : LeeCode No.131
 */
public class partition {

    private static List<List<String>> partitionResult(String s) {
        List<List<String>> lists = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (judge(sub)) {
                List<String> list = new ArrayList<>();
                list.add(sub);
                dfs(s, i, lists, list);
            }
        }
        return lists;
    }


    private static void dfs(String s, int start, List<List<String>> lists, List<String> list) {
        //System.out.println(list.toString());
        if (start == s.length()) {
            lists.add(list);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (judge(sub)) {
                List<String> list1 = new ArrayList<>(list);
                list1.add(sub);
                dfs(s, i, lists, list1);
            }
        }
    }

    private static boolean judge(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = partitionResult("");
        for (List<String> list : lists)
            System.out.println(list.toString());
    }
}
