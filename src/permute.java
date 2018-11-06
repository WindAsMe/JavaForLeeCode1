
import java.util.LinkedList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : permute.java
 * Time       : Create on 18-7-9
 * Location   : ../Home/JavaForLeeCode/permute.java
 * Function   : LeeCode No.46
 */
public class permute {

    private static List<List<Integer>> permuteResult(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> first = new LinkedList<>();
        first.add(0, nums[0]);
        result.add(first);
        List<Integer> temp;
        for(int i = 1; i < nums.length; i ++) {
            int number = nums[i];
            do {
                temp = result.removeFirst();
                for(int j = 0; j <= temp.size(); j ++) {
                    temp.add(j, number);
                    result.add(new LinkedList<>(temp));
                    temp.remove(j);
                }
            } while (result.getFirst().size() == i);
        }
        return result;
    }

    public static void main (String[] args) {
        int[] nums = {1,4,6,7,3};
        System.out.println(permuteResult(nums).toString());
    }
}
