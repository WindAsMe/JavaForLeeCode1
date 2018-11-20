/**
 * Author     : WindAsMe
 * File       : stoneGame.java
 * Time       : Create on 18-11-20
 * Location   : ../Home/JavaForLeetCode/stoneGame.java
 * Function   : LeetCode No.877
 */
public class stoneGame {

    private static boolean stoneGameResult(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for(int dis = 1; dis < n; dis++) {
            for(int i = 0; i < n - dis; i++)
                dp[i][i + dis] = Math.max(piles[i] - dp[i + 1][i + dis], piles[i + dis] - dp[i][i + dis - 1]);
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        int[] piles = {5,3,2,4};
        System.out.println(stoneGameResult(piles));
    }

}
