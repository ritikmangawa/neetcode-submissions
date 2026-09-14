class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxdp = new int[n];
        int[] mindp = new int[n];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int ans = nums[0];

        for(int i = 1; i < n; i++){
            maxdp[i] = Math.max(nums[i],Math.max( maxdp[i -1] * nums[i], mindp[i-1] * nums[i]));
            mindp[i] = Math.min(nums[i], Math.min(maxdp[i -1] * nums[i], mindp[i-1] * nums[i]));

            ans = Math.max(ans, maxdp[i]);

        }
        return ans;
    }
}
