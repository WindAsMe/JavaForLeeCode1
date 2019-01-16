
/**
 * Author     : WindAsMe
 * File       : removeDuplicates.java
 * Time       : Create on 18-7-12
 * Location   : ../Home/JavaForLeeCode/removeDuplicates.java
 * Function   : LeeCode No.80
 */
public class removeDuplicates {

    private static int removeDuplicatesResult1(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int j = 0;
        int k = nums[0] - 1;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                nums[j++] = nums[i];
                k = nums[i];
                times = 0;
            } else if (times < 1) {
                nums[j++] = nums[i];
                k = nums[i];
                times++;
            }
        }
        return j;
    }


    private static int removeDuplicatesResult(int[] nums) {
        if(nums.length < 2)
            return nums.length;

        int temp = nums[0];
        int insert = 1;
        boolean gate = false;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == temp) {
                if(!gate){
                    gate = true;
                    nums[insert++] = temp;
                }
            } else {
                gate = false;
                nums[insert++] =nums[i];
                temp = nums[i];
            }
        }
        if(insert < nums.length){
            nums[insert] = nums[insert - 1] + 1;
        }
        return insert;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(removeDuplicatesResult(nums));
    }
}
