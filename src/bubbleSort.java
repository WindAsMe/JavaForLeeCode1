import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : bubbleSort.java
 * Time       : Create on 19-5-21
 * Location   : ../Home/JavaForLeetCode/bubbleSort.java
 */
public class bubbleSort {
    private static int[] bubbleSortResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    private static int[] quickSort(int[] a) {
        quick(a, 0, a.length - 1);
        return a;
    }

    private static void quick(int[] a, int start, int end) {
        if (start >= end)
            return;
        int pivotal = a[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && a[right] >= pivotal)
                right--;
            a[left] = a[right];
            while (left < right && a[left] <= pivotal)
                left++;
            a[right] = a[left];
        }
        a[left] = pivotal;
        quick(a, start, left - 1);
        quick(a, left + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {61, 12, 6, 7, 9, 4, 66, 22, 3, 5, 6};
        System.out.println(Arrays.toString(quickSort(a)));
    }
}
