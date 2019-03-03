import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : getPermutation.java
 * Time       : Create on 18-7-23
 * Location   : ../Home/JavaForLeeCode/getPermutation.java
 * Function   : LeeCode No.60
 */
public class getPermutation {

    private static String getPermutationResult1(int n, int k) {
        int total = 1;
        for (int i = 2; i <= n; i++)
            total *= i;
        if(k > total || k < 1)
            return "";
        int[] all = new int[n];
        for (int i = 0; i < n; i++)
            all[i] = i + 1;
        helper(all, 0, k, total / n);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++)
            result.append(all[i]);
        return result.toString();
    }

    private static void helper(int[] all, int index, int k, int maxOnce) {
        if (k == 1)
            return;
        int i = index;
        for (; i < all.length; i++) {
            if(k - maxOnce < 1)
                break;
            k -= maxOnce;
        }

        int tmp = all[i];
        System.arraycopy(all, index, all, index + 1, i - index);
        all[index] = tmp;
        helper(all, index + 1, k, maxOnce / (all.length - 1 - index));
    }


    // Brutal Procedure: TL
    private static String getPermutationResult(int n, int k) {
        boolean[] flag = new boolean[n + 1];
        Arrays.fill(flag, true);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            flag[i] = false;
            dfs(flag, String.valueOf(i), list);
            flag[i] = true;
        }
        //System.out.println(list.toString());
        return list.get(k - 1);
    }

    private static void dfs(boolean[] flag, String s, List<String> list) {
        //System.out.println(s + Arrays.toString(flag));
        if (s.length() == flag.length - 1)
            list.add(s);
        else {
            boolean[] inFlag = flag.clone();
            for (int i = 1; i < flag.length; i++) {
                if (inFlag[i]) {
                    inFlag[i] = false;
                    dfs(inFlag, s + i, list);
                    inFlag[i] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        int n = 3;
        int k = 4;
        System.out.println(getPermutationResult1(n, k));
    }
}
