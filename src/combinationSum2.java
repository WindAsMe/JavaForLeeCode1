import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : combinationSum2.java
 * Time       : Create on 18-7-21
 * Location   : ../Home/JavaForLeeCode/combinationSum2.java
 * Function   : LeeCode No.40
 */
public class combinationSum2 {

    // 1.Combination
    // 2.Sort the same
    // Can be sorted in Algorithm
    private static List<List<Integer>> combinationSum2Result(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        if (target == 0 || candidates.length < 1)
            return lists;
        dfs(candidates, 0, target, new ArrayList<>(), lists);
        for (int i = 1; i < candidates.length;  i++) {
            if (candidates[i] != candidates[i - 1])
                dfs(candidates, i, target, new ArrayList<>(), lists);
        }
        for (int i = 0; i < lists.size() - 1; i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                List<Integer> l1 = lists.get(i);
                List<Integer> l2 = lists.get(j);
                if (l1.equals(l2)) {
                    lists.remove(j);
                    j--;
                }
            }
        }
        return lists;
    }

    private static void dfs(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> lists) {
        if (target - candidates[index] > 0) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[index]);
            for (int i = index + 1; i < candidates.length; i++) {
                dfs(candidates, i, target - candidates[index], list1, lists);
            }
        } else if (target - candidates[index] == 0) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[index]);
            lists.add(list1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 2, 2, 1, 5};
        int target = 5;
        List<List<Integer>> lists = combinationSum2Result(candidates, target);
        for (List<Integer> l : lists)
            System.out.println(l.toString());
    }
}
