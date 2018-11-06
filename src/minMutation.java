/**
 * Author     : WindAsMe
 * File       : minMutation.java
 * Time       : Create on 18-7-30
 * Location   : ../Home/JavaForLeeCode/minMutation.java
 * Function   : LeeCode No.433
 */
public class minMutation {

    private static int minMutationResult(String start, String end, String[] bank) {
        boolean flag = false;
        for (String s : bank) {
            if (s.equals(end)) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return -1;
        int[] ans = {1, Integer.MAX_VALUE};
        for (String s : bank) {
            if (differ(start, s))
                bfs(ans, s, end, bank);
        }
        return ans[1] == Integer.MAX_VALUE ? -1 : ans[1];
    }

    private static void bfs(int[] i, String current, String end, String[] bank) {
        if (current.equals(end) || i[0] == bank.length) {
            i[1] = Math.min(i[0], i[1]);
        } else {
            for (String s : bank) {
                if (differ(s, current)) {
                    i[0]++;
                    bfs(i, s, end, bank);
                    i[0]--;
                }
            }
        }
    }

    private static boolean differ(String current, String dict) {
        int ans = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != dict.charAt(i))
                ans++;
        }
        return ans == 1;
    }

    public static void main(String[] args) {
        String[] s = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutationResult("AACCGGTT",  "AAACGGTA", s));
    }
}
