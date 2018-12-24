/**
 * Author     : WindAsMe
 * File       : escapeGhosts.java
 * Time       : Create on 18-12-24
 * Location   : ../Home/JavaForLeetCode/escapeGhosts.java
 * Function   : LeetCode No.789
 */
public class escapeGhosts {

    private static boolean escapeGhostsResult(int[][] ghosts, int[] target) {
        double dis = Math.pow(target[0], 2) + Math.pow(target[1], 2);
        for (int[] ghost : ghosts) {
            if (Math.pow(ghost[0] - target[0], 2) + Math.pow(ghost[1] - target[1], 2) <= dis)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
