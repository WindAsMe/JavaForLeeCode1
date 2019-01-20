import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : findLHS.java
 * Time       : Create on 18-6-25
 * Location   : ../Home/JavaForLeeCode/findLHS.java
 * Function   : LeeCode No.594
 */
public class findLHS {

    private static int findLHSResult(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            // getOrDefault（JDK 8）
            map.put(num, map.getOrDefault(num, 0) + 1);
        int max = 0;
        for (int num : map.keySet()) {
            // If map has num + 1, comparing
            if (map.containsKey(num + 1)) {
                int tmp = map.get(num) + map.get(num + 1);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(findLHSResult(nums));
    }
}
