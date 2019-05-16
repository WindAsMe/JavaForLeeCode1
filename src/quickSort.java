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
        int pivotal = arr[0];
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[right] > pivotal)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < pivotal)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivotal;
        sort(arr, 0, left - 1);
        sort(arr, left + 1, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int left, int right) {
        // System.out.println(Arrays.toString(arr));
        if (left >= right)
            return;
        int low = left;
        int high = right;
        int pivotal = arr[low];
        while (low < high) {
            // System.out.println(low + " : " + high);
            while (low < high && arr[high] >= pivotal)
                high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivotal)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivotal;
        sort(arr, low, left - 1);
        sort(arr, left + 1, right);
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
        if (l > low)
            quickSortResult(arr, low, l - 1);
        if (h < high)
            quickSortResult(arr, l + 1, high);
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {61, 12, 6, 7, 9, 4, 66, 22, 3, 5, 6};
        // System.out.println(Arrays.toString(quickSortResult(nums, 0, nums.length - 1)));
        System.out.println(Arrays.toString(quickSortResult1(nums)));
    }
}
