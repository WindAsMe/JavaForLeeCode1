import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : nextGreaterElement.java
 * Time       : Create on 18-7-30
 * Location   : ../Home/JavaForLeeCode/nextGreaterElement.java
 * Function   : LeeCode No.496
 */
public class nextGreaterElement {

    private static int[] nextGreaterElementResult(int[] nums1, int[] nums2) {
        // Save the (nums2[i], i)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++)
            map.put(nums2[i], i);
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            boolean flag = false;
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag)
                ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElementResult(nums1, nums2)));
    }
}
