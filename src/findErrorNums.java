import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findErrorNums.java
 * Time       : Create on 18-7-1
 * Location   : ../Home/JavaForLeeCode/findErrorNums.java
 * Function   : LeeCode No.645
 */
public class findErrorNums {

    private static int[] findErrorNumsResult(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int corSum = (1 + nums.length) * nums.length / 2;
        int sum = 0;

        for (int num: nums) {
            if(set.contains(num))
                res[0] = num;
            else {
                set.add(num);
                sum += num;
            }
        }
        res[1] = corSum - sum;
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(Arrays.toString(findErrorNumsResult(nums)));
    }
}
