class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxP = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++ ){
            
            
            maxP = Math.max(prices[i] - buy, maxP);
            buy = Math.min(buy, prices[i]);
        
        }
        return maxP;
        
    }
}
