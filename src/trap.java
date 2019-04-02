
/**
 * Author     : WindAsMe
 * File       : trap.java
 * Time       : Create on 18-7-21
 * Location   : ../Home/JavaForLeeCode/trap.java
 * Function   : LeeCode No.42
 */
public class trap {

    private static int trapResult(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] > leftMax)
                    leftMax = height[left];
                else
                    res += leftMax - height[left];
                left++;
            } else {
                if(height[right] > rightMax)
                    rightMax = height[right];
                else
                    res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapResult(h));
    }
}
