import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : combinationSum.java
 * Time       : Create on 18-5-29
 * Location   : ../Home/JavaForLeeCode/combinationSum.java
 * Function   : LeeCode No.39
 */

public class combinationSum {
    private static List<List<Integer>> combinationSumResult(int[] candidates, int target) {
        List<List<Integer>> LList = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length < 1 || target < 1 )
            return LList;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        combinationSumCore(candidates,list, target, 0, LList);
        return LList;
    }
    private static void combinationSumCore(int[] candidates,List<Integer> list, int target, int index, List<List<Integer>> LList)
    {
        for(int i = index; i < candidates.length; i++)
        {
            if(candidates[i] == target)
            {
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(list);
                result.add(candidates[i]);
                LList.add(result);
            }
            else if(candidates[i] < target) {
                List<Integer> result = new ArrayList<Integer>();
                result.addAll(list);
                result.add(candidates[i]);
                combinationSumCore(candidates, result, target - candidates[i], i, LList);
            }
            else  {
                break;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> lists = combinationSumResult(nums, 4);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
