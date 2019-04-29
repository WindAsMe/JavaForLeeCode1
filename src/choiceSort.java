import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : choiceSort.java
 * Time       : Create on 19-4-29
 * Location   : ../Home/JavaForLeetCode/choiceSort.java
 */
public class choiceSort {

    private static void choiceSortResult(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int[] array = arrayMin(i + 1, A.length, A);
            int temp = A[i];
            A[i] = array[0];
            A[array[1]] = temp;
        }
        System.out.println(Arrays.toString(A));
    }

    private static int[] arrayMin(int start, int end, int[] A) {
        int[] array = {A[start], start};

        for (int i = start; i < end; i++) {
            if (A[i] < array[0]) {
                array[0] = A[i];
                array[1] = i;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] A = {6, 1, 7, 8, 9, 3, 5, 4, 2};

    }
}
