class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        if ((target + sum) % 2 != 0) {
            return 0;
        }

        return countSubset(nums, (sum + target) / 2);
    }

    static int countSubset(int[] nums, int sum) {

        int[][] dp = new int[nums.length + 1][sum + 1];

        // Initialization
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {

                if (i == 0) {
                    dp[i][j] = 0;
                }

                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        // DP
        for (int i = 1; i < nums.length + 1; i++) {

            for (int j = 0; j < sum + 1; j++) {

                if (nums[i - 1] <= j) {

                    dp[i][j] =
                        dp[i - 1][j]
                        + dp[i - 1][j - nums[i - 1]];

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][sum];
    }
}
