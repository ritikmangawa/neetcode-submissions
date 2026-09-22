class Solution {
    public int change(int amount, int[] coins) {
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0)  dp[i][j] = 1;
            }
        }
        for (int i = 1; i < m+ 1; i++){
            for(int j = 1; j < n+ 1; j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
