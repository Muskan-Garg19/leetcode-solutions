class Solution {
    private static int helper(int[] prices, int i, int buyStatus, int fee, int[][] dp) {
        if(i == prices.length) {
            return 0;
        }
        if(dp[i][buyStatus] != -1) {
            return dp[i][buyStatus];
        }
        if(buyStatus == 0) {
            int buy = helper(prices, i+1, 1, fee, dp) - prices[i];
            int notBuy = helper(prices, i+1, 0, fee, dp);
            return dp[i][buyStatus] = Math.max(buy, notBuy);
        }
        else {
            int sell = helper(prices, i+1, 0, fee, dp) + prices[i] - fee;
            int notSell = helper(prices, i+1, 1, fee, dp);
            return dp[i][buyStatus] = Math.max(sell, notSell);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return helper(prices, 0, 0, fee, dp);
    }
}