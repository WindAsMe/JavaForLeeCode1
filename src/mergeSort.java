/**
 * Author     : WindAsMe
 * File       : mergeSort.java
 * Time       : Create on 19-5-19
 * Location   : ../Home/JavaForLeetCode/mergeSort.java
 */
public class mergeSort {

    private static int number = 0;

    private static void printArray(String pre,int[] a) {
        System.out.print(pre + "\n");
        for (int anA : a)
            System.out.print(anA + "\t");
        System.out.println();
    }

    private static void MergeSort(int[] a) {
        System.out.println("Start");
        Sort(a, 0, a.length - 1);
    }

    private static void Sort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        Sort(a, left, mid);
        Sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1])
                tmp[tIndex++] = a[left++];
            else
                tmp[tIndex++] = a[r1++];
        }
        // merge the left
        while (left <= mid)
            tmp[tIndex++] = a[left++];
        // merge the right
        while ( r1 <= right )
            tmp[tIndex++] = a[r1++];
        System.out.println("In " + (++number) + " times:\t");
        // copy the temp data
        while (cIndex <= right){
            a[cIndex] = tmp[cIndex];
            System.out.print(a[cIndex] + "\t");
            cIndex++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        printArray("before: ", a);
        MergeSort(a);
        printArray("after: ", a);
    }
}
