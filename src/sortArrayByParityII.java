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
        sort(A, 0);
        return A;
    }


    private static void sort(int[] a, int index) {
        if (index < a.length) {
            if (index % 2 == 1) {
                if (a[index] % 2 == 0) {
                    for (int i = index + 1; i < a.length; i++) {
                        if (a[i] % 2 == 0) {
                            int temp = a[i];
                            a[i] = a[index];
                            a[index] = temp;
                        }
                    }
                }
            } else {
                if (a[index] % 2 == 1) {
                    for (int i = index + 1; i < a.length; i++) {
                        if (a[i] % 2 == 1) {
                            int temp = a[i];
                            a[i] = a[index];
                            a[index] = temp;
                        }
                    }
                }

            }
            sort(a, ++index);
        }
    }



    public static void main(String[] args) {
        int[] a = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityIIResult(a)));
    }
}
