class Solution {
    private static int helper(int[] prices, int[][][] dp, int i, int buyStatus, int transaction) {
        if(i == prices.length || transaction == 2) {
            return 0;
        }
        if(dp[i][buyStatus][transaction] != -1) {
            return dp[i][buyStatus][transaction];
        }

        if(buyStatus == 0) {
            if(transaction < 2) {
                int buy = helper(prices, dp, i+1, 1, transaction) - prices[i];
                int notBuy = helper(prices, dp, i+1, 0, transaction);
                return dp[i][buyStatus][transaction] = Math.max(buy, notBuy);
            }
            else {
                return dp[i][buyStatus][transaction] = helper(prices, dp, i+1, 0, transaction);
            }
        }
        else {
            int sell = helper(prices, dp, i+1, 0, transaction+1) + prices[i];
            int notSell = helper(prices, dp, i+1, 1, transaction);
            return dp[i][buyStatus][transaction] = Math.max(sell, notSell);
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                for(int k=0; k<2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(prices, dp, 0, 0, 0);
    }
}