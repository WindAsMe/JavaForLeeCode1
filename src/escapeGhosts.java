/**
 * Author     : WindAsMe
 * File       : escapeGhosts.java
 * Time       : Create on 18-12-24
 * Location   : ../Home/JavaForLeetCode/escapeGhosts.java
 * Function   : LeetCode No.789
 */
public class escapeGhosts {

    private static boolean escapeGhostsResult(int[][] ghosts, int[] target) {
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= dis)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ghosts = {
                {1, 8},
                {-9, 0},
                {-7, -6},
                {4, 3},
                {1, 3}
        };
        int[] target = {6, -9};
        System.out.println(escapeGhostsResult(ghosts, target));
    }
}
