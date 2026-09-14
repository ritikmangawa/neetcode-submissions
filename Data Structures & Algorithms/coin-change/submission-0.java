class Solution {

    static final int INF = Integer.MAX_VALUE - 1;

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= amount; j++) {

                if (i == 0) {
                    dp[i][j] = INF;
                }

                if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Only first coin available
        for (int j = 1; j <= amount; j++) {

            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = INF;
            }
        }

        // Remaining coins
        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= amount; j++) {

                if (coins[i - 1] <= j) {

                    dp[i][j] = Math.min(
                        dp[i - 1][j],
                        1 + dp[i][j - coins[i - 1]]
                    );

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount] == INF ? -1 : dp[n][amount];
    }
}