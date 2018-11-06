import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : MapSum.java
 * Time       : Create on 18-7-5
 * Location   : ../Home/JavaForLeeCode/MapSum.java
 * Function   : LeeCode No.677
 */
public class MapSum {

    /** Initialize your data structure here. */
    private Map<String, Integer> map;
    private MapSum() {
        map = new HashMap<>();
    }

    private void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        // Iteration in map
        for (Map.Entry<String, Integer> temp : map.entrySet()) {
            // The prefix.length() must equal or shorter than key
            // If or not key.substring(0, prefix.length()).equal(prefix)
            if (temp.getKey().length() >= prefix.length() && temp.getKey().substring(0, prefix.length()).equals(prefix)) {
                sum += temp.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("b", 2);
        System.out.println(mapSum.sum("a"));
    }
}
