import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : subsets.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/subsets.java
 * Function   : LeeCode No.78
 */
public class subsets {

    private static List<List<Integer>> subsetsResult(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        for (List<Integer> a : ans)
            System.out.println(a.toString());
        return ans;

    }

    private static void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> ret) {
        ret.add(path);
        for (int i = idx; i < nums.length; i++) {
            // NOT DIRECTLY ADD path
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            dfs(nums, i + 1, p, ret);
        }
    }





    // If input is {1, 2, 3}
    // Then {{}, {1}, {1, 2}, {1, 2, 3}, {2}, {2, 3}, {3}}
    private static List<List<Integer>> subsetsResult1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            lists.add(new ArrayList<>());
            return lists;
        }
        // [] is needed
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i ++) {
            List<Integer> list = new ArrayList<>();
            recursion1(lists, list, nums, i);
        }
        for (List<Integer> a : lists)
            System.out.println(a.toString());
        return lists;
    }

    private static void recursion1(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        if (index < nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[index]);
            lists.add(temp);
            for (int i = index + 1; i < nums.length; i ++) {
                recursion1(lists, temp, nums, i ++);
            }
        }
    }


//    private static List<List<Integer>> list=new ArrayList<List<Integer>>();
//
//    private static List<List<Integer>> subsetsResult1(int[] nums) {
//        List<Integer> list1=new ArrayList<Integer>();
//        backTrack(0,nums,list1);
//        return list;
//    }
//
//    private static void backTrack(int i,int[] nums,List<Integer> currentList){
//        list.add(currentList);
//        for(int j = i ; j < nums.length ; j++){
//            if(j == i || nums[j]!=nums[j - 1]){
//                currentList.add(nums[j]);
//                backTrack(j + 1, nums,new ArrayList<Integer>(currentList));
//                currentList.remove(currentList.size()-1);
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsetsResult(nums);
    }
}
