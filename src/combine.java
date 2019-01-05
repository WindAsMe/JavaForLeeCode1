import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : combine.java
 * Time       : Create on 18-7-11
 * Location   : ../Home/JavaForLeeCode/combine.java
 * Function   : LeeCode No.77
 */
public class combine {

    private static List<List<Integer>>	lists	= new ArrayList<>();

    private static List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        lists.clear();
        dfs(n, k, 0, 1, list);
        return lists;
    }

    private static void dfs(int n, int k, int level, int idx, ArrayList<Integer> list) {
        if (level >= k) {
            List<Integer> copy = new ArrayList<>(list);
            lists.add(copy);
            return;
        }
        for (int i = idx; i <= n; i++) {
            list.add(i);
            dfs(n, k, level + 1, i + 1, list);
            list.remove(new Integer(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(5, 2));
        System.out.println(combine(4, 2));
    }
}
