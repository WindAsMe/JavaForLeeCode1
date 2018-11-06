import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : singleNumber.java
 * Time       : Create on 18-7-28
 * Location   : ../Home/JavaForLeeCode/singleNumber.java
 * Function   : LeeCode No.260
 */
public class singleNumber {

    private static int[] singleNumberResult(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        int mark = 0;
        for (int num : nums) {
            map.merge(num, 1, (a, b) -> a + b);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[mark] = entry.getKey();
                mark++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0};
        System.out.println(Arrays.toString(singleNumberResult(nums)));
    }
}
