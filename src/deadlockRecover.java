import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : deadlockRecover.java
 * Time       : Create on 18-12-21
 * Location   : ../Home/JavaForLeetCode/deadlockRecover.java
 * Function   : Recover the deadlock
 */
public class deadlockRecover {

    private static boolean recover(int[] resource, int[][] current, int[][] needed, List<Integer> list) {
        System.out.println(list.toString());
        for (int i = 0; i < current.length; i++) {
            if (list.size() == current.length)
                return true;
            else if (!list.contains(i)) {
                if (judge(resource, needed[i])) {
                    int[] r = resource.clone();
                    int[][] c = current.clone();
                    List<Integer> list1 = new ArrayList<>(list);
                    list1.add(i);
                    for (int j = 0; j < r.length; j++) {
                        r[j] += c[i][j];
                        c[i][j] = 0;
                    }
                    if (recover(r, c, needed, list1))
                        return true;
                }
            }
        }
        return false;
    }

    // Current resource can satisfy the needed
    private static boolean judge(int[] resource, int[] needed) {
        for (int i = 0; i < resource.length; i++) {
            if (resource[i] < needed[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] resource = {2, 1, 0, 0};
        int[][] current = {
                {0, 0, 0, 0},
                {2, 0, 0 ,1},
                {0, 1, 2, 0}
        };
        int[][] needed = {
                {1, 1, 0, 0},
                {1, 0, 1, 0},
                {2, 2, 0, 0}
        };
        System.out.println(recover(resource, current, needed, new ArrayList<>()));
    }
}
