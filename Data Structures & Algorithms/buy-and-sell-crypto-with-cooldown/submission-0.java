// class Solution {
//     public int maxProfit(int[] prices) {

//         dfs(0, true, prices);

//     }
//     private int dfs(int i, boolean buying, int[] prices){
//         if( i >= prices.length){
//             return 0;
//         }
//         int cooldown = dfs(i + 1, buying, prices);

//         if(buying){
//             int buy = dfs(i+1, false, prices) - prices[i];
//             return Math.max(buy, cooldown);
//         } else {
//             int sell = dfs(i + 2, true, prices) + prices[i];
//             return Math.max(sell, cooldown);

//         }
//     }
// }
// class Solution {
//     public int maxProfit(int[] prices){
//         int n = prices.length;
//         int[][] dp = new int[n + 1][2];
//         for(int i = n - 1; i >= 0; i--){
//             for(int buy = 1; buying >= 0; buying--){
                
//                 for(int buying = 1; buying>= 0; buying--){
//                     if(buying == 1){
//                         int buy = dp[i+1][0] - prices[i];
//                         int cooldown = dp[i + 1][1];
//                         dp[i][1] = Math.max(buy, cooldown);
//                     } else {
//                         int sell = (i + 2 < n) ?
//                     }
                    
//                 }
//             }
//         }
//     }
// }

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[i][buying]
        // -1 means state has not been calculated yet
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return dfs(0, 1, prices, dp);
    }

    private int dfs(int i, int buying, int[] prices, int[][] dp) {

        // No days left
        if (i >= prices.length) {
            return 0;
        }

        // Already calculated
        if (dp[i][buying] != -1) {
            return dp[i][buying];
        }

        // Option 1: Do nothing
        int cooldown = dfs(i + 1, buying, prices, dp);

        if (buying == 1) {

            // Buy today
            int buy = dfs(i + 1, 0, prices, dp) - prices[i];

            dp[i][1] = Math.max(buy, cooldown);

        } else {

            // Sell today
            int sell = dfs(i + 2, 1, prices, dp) + prices[i];

            dp[i][0] = Math.max(sell, cooldown);
        }

        return dp[i][buying];
    }
}
