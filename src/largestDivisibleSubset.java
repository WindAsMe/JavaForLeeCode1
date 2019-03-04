import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : largestDivisibleSubset.java
 * Time       : Create on 18-6-23
 * Location   : ../Home/JavaForLeeCode/largestDivisibleSubset.java
 * Function   : LeeCode No.368
 */
public class largestDivisibleSubset {

    // DP: Judge the current index element(may already update before)
    // With the needed key's value + certain
    // EVERY STEP is the most beneficial
    private static List<Integer> largestDivisibleSubsetResult(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        // record current list
        List<List<Integer>> dp = new ArrayList<>();
        // the first element is only one
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        dp.add(first);
        // record current length
        int[] length = new int[n];
        // init the length array
        for (int i = 0; i < n; i++)
            length[i] = 1;
        for (int i = 1; i < n; i++) {
            // save the current value
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    length[i] = Math.max(length[i], length[j] + 1);
                    // means use the nums[j]'s string
                    // is much longer
                    if (length[i] == length[j] + 1)
                        current = new ArrayList<>(dp.get(j));
                }
            }
            current.add(nums[i]);
            dp.add(current);
        }
        int maxLength = -1;
        int maxIndex = -1;
        for (int i = 0; i < dp.size(); i++) {
            maxLength = Math.max(maxLength, dp.get(i).size());
            maxIndex = maxLength == dp.get(i).size() ? i : maxIndex;
        }
        return dp.get(maxIndex);
    }


    // Greedy Algorithm is not proper
//    private static List<Integer> largestDivisibleSubsetResult(int[] nums) {
//        if (nums.length == 0) return new ArrayList<>();
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        // Mark the current max length and index
//        int maxLength = -1;
//        int maxIndex = 0;
//        List<List<Integer>> lists = new ArrayList<>();
//        // DP set each element as the first
//        for (int i = 0 ; i < nums.length ; i ++ ) {
//            List<Integer> list = new ArrayList<>();
//            int before = nums[i];
//            list.add(before);
//            for (int j = i + 1 ; j < nums.length ; j ++ ) {
//                if (nums[j] % before == 0) {
//                    before = nums[j];
//                    list.add(before);
//                }
//            }
//            maxLength = Math.max(maxLength, list.size());
//            maxIndex = maxLength == list.size() ? i : maxIndex;
//            lists.add(list);
//        }
//        System.out.println(maxIndex + " " + maxLength);
//        for (List<Integer> list : lists) {
//            for (Integer i : list) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//
//        return lists.get(maxIndex);
//    }


    public static void main(String[] args) {
        int[] nums = {5, 180, 34};
        // int[] nums = {4,8,10,240};
        List<Integer> list = largestDivisibleSubsetResult(nums);
        for (Integer i : list)
            System.out.print(i + " ");
    }
}
