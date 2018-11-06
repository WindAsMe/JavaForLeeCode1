import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : subsetsWithDup.java
 * Time       : Create on 18-7-24
 * Location   : ../Home/JavaForLeeCode/subsetsWithDup.java
 * Function   : LeeCode No.90
 */
public class subsetsWithDup {

    // Foremost, sort can reduce the complex
    private static List<List<Integer>> subsetsWithDupResult(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            lists.add(new ArrayList<>());
            return lists;
        }
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            dfs(lists, new ArrayList<>(), nums, i);
        }
        for (int i = 0; i < lists.size(); i++) {
            for (int j = i + 1; j < lists.size(); j++) {
                if (isSame(lists.get(i), lists.get(j))) {
                    lists.remove(j);
                    j--;
                }
            }
        }
        return lists;
    }

    private static boolean isSame(List<Integer> l1, List<Integer> l2) {
        if (l1.size() == l2.size()) {
            int[] nums1 = new int[50];
            int[] nums2 = new int[50];
            for (int i = 0; i < l1.size(); i++) {
                // If list.get(1) < 0
                nums1[(l1.get(i) + 50) % 50] += 1;
                nums2[(l2.get(i) + 50) % 50] += 1;
            }
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] != nums2[i])
                    return false;
            }
            return true;
        }
        return false;
    }

    private static void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        List<Integer> l = new ArrayList<>(list);
        if (index < nums.length) {
            l.add(nums[index]);
            lists.add(l);
        }
        if (l.size() == nums.length)
            return;
        for (int i = index + 1; i < nums.length; i++) {
            dfs(lists, l, nums, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,2};
        List<List<Integer>> lists = subsetsWithDupResult(nums);
        for (List<Integer> l : lists)
            System.out.println(l.toString());
    }
}
