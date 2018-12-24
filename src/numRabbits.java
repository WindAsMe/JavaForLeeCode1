import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : numRabbits.java
 * Time       : Create on 18-12-24
 * Location   : ../Home/JavaForLeetCode/numRabbits.java
 * Function   : LeetCode No.781
 */
public class numRabbits {

    private static int numRabbitsResult(int[] answers) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : answers) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int div = entry.getValue() / (entry.getKey() + 1);
            int per = entry.getValue() % (entry.getKey() + 1);
            if (per > 0)
                ans += (entry.getKey() + 1) * (div + 1);
            else
                ans += entry.getKey() + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = {1, 1, 2};
        System.out.println(numRabbitsResult(ans));
    }
}
