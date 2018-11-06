import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : numSquares.java
 * Time       : Create on 18-6-9
 * Location   : ../Home/JavaForLeeCode/numSquares.java
 * Function   : LeeCode No.279
 */
public class numSquares {

    private static int numSquaresResult(int n) {
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(n);
        int i = 0;
        while (list.get(i) >= 1) {
            for (int index = list.get(i); index > 0; index--) {
                double temp = Math.sqrt(index);
                if ((int) temp * (int) temp == index) {
                    n = n - index;
                    index = n + 1;
                    count++;
                    list.add((int)temp);
                    System.out.println("temp: " + temp + " n: " + n + " count: " + count);
                }
            }
            i ++;
            minCount = Math.min(minCount, count);

        }
        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(numSquaresResult(12));
    }
}
