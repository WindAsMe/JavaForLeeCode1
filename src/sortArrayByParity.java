import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : sortArrayByParity.java
 * Time       : Create on 18-12-14
 * Location   : ../Home/JavaForLeetCode/sortArrayByParity.java
 * Function   : LeetCode No.905
 */
public class sortArrayByParity {

    private static int[] sortArrayByParityResult(int[] A) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int a : A) {
            if (a % 2 == 1)
                odd.add(a);
            else
                even.add(a);
        }
        even.addAll(odd);
        return even.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParityResult(a)));
    }
}
