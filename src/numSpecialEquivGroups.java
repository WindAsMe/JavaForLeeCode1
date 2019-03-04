import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : numSpecialEquivGroups.java
 * Time       : Create on 18-12-13
 * Location   : ../Home/JavaForLeetCode/numSpecialEquivGroups.java
 * Function   : LeetCode No.893
 */
public class numSpecialEquivGroups {

    private static int numSpecialEquivGroupsResult(String[] A) {
        Set<String> strSet = new HashSet<>();
        for (String tmp : A)
            strSet.add(strHash(tmp));
        return strSet.size();
    }

    private static String strHash(String tmp) {
        if (tmp.length() == 1)
            return tmp;
        int[] cArr = new int[52];
        int odd = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : tmp.toCharArray())
            cArr[(odd++ % 2 == 0 ? 26 : 0) + c - 'a']++;
        for (int i : cArr)
            sb.append(i);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] A = {"abc", "acb", "bac", "bca", "cab", "cba"};
        System.out.println(numSpecialEquivGroupsResult(A));
    }
}
