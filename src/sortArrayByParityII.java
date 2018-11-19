import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : sortArrayByParityII.java
 * Time       : Create on 18-11-19
 * Location   : ../Home/JavaForLeetCode/sortArrayByParityII.java
 * Function   : LeetCode No.922
 */
public class sortArrayByParityII {

    private static int[] sortArrayByParityIIResult(int[] A) {
        int[] ans = new int[A.length];
        int even = 0;
        int odd = 1;
        for (int a : A) {
            if (a % 2 == 0) {
                ans[even] = a;
                even += 2;
            } else {
                ans[odd] = a;
                odd += 2;
            }
        }
        return ans;
    }

    private static int[] sortArrayByParityIIResult1(int[] A) {
        sort(A, 0);
        return A;
    }


    private static void sort(int[] a, int index) {
        if (index < a.length) {
            if (a[index] % 2 != index % 2) {
                for (int i = index + 1; i < a.length; i++) {
                    if (a[i] % 2 == index % 2) {
                        int temp = a[i];
                        a[i] = a[index];
                        a[index] = temp;
                    }
                }
            }
            sort(a, ++index);
        }
    }



    public static void main(String[] args) {
        int[] a = {3,3,3,0,1,0,2,4,3,1,1,2,2,1,1,0,0,1,0,3,1,0,0,2,4,1,2,1,3,1,3,4,2,2,3,2,2,3,4,0,3,3,3,3,0,4,2,1,1,2,2,4,1,0,1,2,3,3,0,1,2,3,3,3,3,0,4,2,1,3,3,0,3,1,3,4,1,3,1,0,3,0,2,4,2,3,2,4,3,3,1,0,4,3,3,4,3,1,2,4,4,4,3,1,4,2,4,3,2,0,4,2,0,1,2,3,1,1,4,0,4,4,0,1,2,2,3,1,4,2,1,3,0,1,0,1,1,1,1,3,2,3,3,0,4,4,3,1,1,0,1,1,0,0,3,3,1,0,1,1,3,1,2,3,0,3,3,4,1,2,0,3,1,0,4,2,3,1,3,4,1,2,1,1,4,3,2,1,3,0,2,0,4,2,4,2,0,3,2,3,0,2,2,0,1,4,4,0,1,2,1,3,0,3,4,1,1,3,2,3,1,4,1,4,3,1,1,0,4,0,1,4,4,2,0,1,4,1,0,2,0,3,0,0,1,3,1,4,1,2,4,1,3,4,1,0,1,1,1,0,1,2,0,3,0,4,1,3,4,3,4,2,3,3,0,3,3,1,3,1,4,0,2,0,3,4,1,3,1,4,2,0,0,4,3,1,3,3,2,0,3,0,1,3,4,0,2,1,1,3,1,4,0,2,4,0,1,3,3,1,1,3,2,3,1,4,1,2,3,1,3,3,0,3,3,3,4,3,3,2,3,0,3,4,2,3,2,0,0,1,4,2,2,1,0,1,1,4,3,1,2,4,3,0,2,2,3,2,0,1,0,3,1,0,4,0,3,1,1,1,0,1,1,3,1,3,2,1,1,2,1,0,3,3,3,1,0,2,0,1,1,4,3,0,4,4,0,3,1,1,1,0,0,2,2,3,2,0,2,2,0,1,3,1,2,3,3,2,4,0,4,0,1,1,3,0,1,3,4,4,3,1,0,4,4,2,3,0,0,3,4,1,3,4,4,4,4,3,1,4,0,4,2,2,2,0,2,3,4,3,4,3,4,1,0,4,1,3,2,1,4,4,1,0,2,2,4,1,2,1,3,0,1,3,0,3,4,2,0,0};
        System.out.println(Arrays.toString(sortArrayByParityIIResult1(a)));
    }
}
