import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : quickSort.java
 * Time       : Create on 18-7-2
 * Location   : ../Home/JavaForLeeCode/quickSort.java
 * Function   : Quick sort
 */
public class quickSort {

    private static int[] quickSortResult1(int[] arr) {

    }








    private static int[] quickSortResult(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];
        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while (l < h && arr[l] <= povit)
                l++;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("l = " + (l + 1) + " h = " + (h + 1) + "povit = " + povit + "\n");
        if(l > low)quickSortResult(arr, low, l - 1);
        if(h < high)quickSortResult(arr, l + 1, high);
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {61, 12, 6, 7, 9, 4, 66, 22, 3, 5, 6};
        System.out.println(Arrays.toString(quickSortResult(nums, 0, nums.length - 1)));
    }
}
