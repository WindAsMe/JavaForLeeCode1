import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : numSpecialEquivGroups.java
 * Time       : Create on 18-12-13
 * Location   : ../Home/JavaForLeetCode/numSpecialEquivGroups.java
 * Function   : LeetCode No.893
 */
public class numSpecialEquivGroups {

    private static int numSpecialEquivGroupsResult(String[] A) {
        Map<String, Integer> map = new HashMap<>();
        for (String a : A) {
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int i = 0; i < A.length; i += 2)
                even.append(A[i]);
            for (int i = 1; i < A.length; i += 2)
                odd.append(A[i]);
            if (map.containsKey(even.append(odd).toString()))
                map.put(even.append(odd).toString(), map.get(even.append(odd).toString()) + 1);
            else
                map.put(even.append(odd).toString(), 1);
        }
        return map.size();
    }

    public static void main(String[] args) {
        String[] A = {"a","b","c","a","c","c"};
        System.out.println(numSpecialEquivGroupsResult(A));
    }
}
