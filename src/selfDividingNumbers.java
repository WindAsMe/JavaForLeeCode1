import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : selfDividingNumbers.java
 * Time       : Create on 18-7-4
 * Location   : ../Home/JavaForLeeCode/selfDividingNumbers.java
 * Function   : LeeCode No.
 */
public class selfDividingNumbers {

    private static List<Integer> selfDividingNumbersResult(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i ++) {
            if (isSelf(i))
                list.add(i);
        }
        return list;
    }

    private static boolean isSelf(int i) {
        int judge = i;
        while (judge > 0) {
            if (judge % 10 == 0)
                return false;
            judge /= 10;
        }
        int temp = i;
        int s = temp % 10;
        while (temp > 0) {
            if (i % s == 0) {
                temp /= 10;
                s = temp % 10;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbersResult(1,22).toString());
    }
}
