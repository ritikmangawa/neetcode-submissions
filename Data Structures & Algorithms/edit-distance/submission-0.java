class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        // for(int i = 0; i < m+1; i++){
        //     for(int j = 0; j < n+1; j++){
        //         // if(i==0||j == 0){
        //         //     dp[i][j] = 0;
        //         // }

        //     }
        // }
                // First column
        // Convert word1[0...i] -> empty string
        // Need i deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // First row
        // Convert empty string -> word2[0...j]
        // Need j insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j -1];
                } else {
                    //dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    // Delete
                    int deletion = dp[i - 1][j];

                    // Insert
                    int insertion = dp[i][j - 1];

                    // Replace
                    int replacement = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                        deletion,
                        Math.min(insertion, replacement)
                    );
                }
            }
        }
        return dp[m][n];
        // int lcs = dp[m][n];
        // int inseration = word2.length() - lcs;
        // int deletion = word1.length() - lcs;

        // return inseration +deletion;


        
    }
}
