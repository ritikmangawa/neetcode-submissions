class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int ans1 = helper(Arrays.copyOfRange(nums, 0, n - 1));
        int ans2 = helper (Arrays.copyOfRange(nums, 1, n));
        return Math.max(ans1, ans2); 
    }
    int helper(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n ; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];

    }
}
