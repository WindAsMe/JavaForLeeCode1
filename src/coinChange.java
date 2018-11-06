import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : coinChange.java
 * Time       : Create on 18-7-17
 * Location   : ../Home/JavaForLeeCode/coinChange.java
 * Function   : LeeCode No.322
 */
public class coinChange {

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = 0x7fff_fffe;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
    }

    private static int coinChangeResult(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // Correlate the index and target
        for (int i = 1; i <= amount; i++ ) {
            dp[i] = Integer.MAX_VALUE;
            System.out.println(Arrays.toString(dp));
            for(int k : coins) {
                if(i >= k && dp[i - k] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - k] + 1,dp[i]);
                }
            }
        }
        if(dp[amount] < Integer.MAX_VALUE && dp[amount] > 0) {
            return dp[amount];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChangeResult(coins, 11));
    }
}
