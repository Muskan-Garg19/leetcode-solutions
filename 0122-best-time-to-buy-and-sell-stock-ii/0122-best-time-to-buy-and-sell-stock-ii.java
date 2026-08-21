class Solution {
    private static int helper(int[] prices, int i, int buyStatus, int[][] dp) {
        if(i == prices.length) {
            return 0;
        }
        if(dp[i][buyStatus] != -1) {
            return dp[i][buyStatus];
        }
        if(buyStatus == 1) {
            int sell = helper(prices, i+1, 0, dp) + prices[i];
            int notSell = helper(prices, i+1, 1, dp);
            return dp[i][buyStatus] = Math.max(sell, notSell);
        }
        else {
            int buy = helper(prices, i+1, 1, dp) - prices[i];
            int notBuy = helper(prices, i+1, 0, dp);
            return dp[i][buyStatus] = Math.max(buy, notBuy);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return helper(prices, 0, 0, dp);
    }
}