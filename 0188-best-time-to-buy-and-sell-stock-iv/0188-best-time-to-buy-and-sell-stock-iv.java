class Solution {
    private static int helper(int[] prices, int[][][] dp, int i, int buyStatus, int transaction, int k) {
        if(i == prices.length || transaction == k) {
            return 0;
        }
        if(dp[i][buyStatus][transaction] != -1) {
            return dp[i][buyStatus][transaction];
        }

        if(buyStatus == 0) {
            if(transaction < k) {
                int buy = helper(prices, dp, i+1, 1, transaction, k) - prices[i];
                int notBuy = helper(prices, dp, i+1, 0, transaction, k);
                return dp[i][buyStatus][transaction] = Math.max(buy, notBuy);
            }
            else {
                return dp[i][buyStatus][transaction] = helper(prices, dp, i+1, 0, transaction, k);
            }
        }
        else {
            int sell = helper(prices, dp, i+1, 0, transaction+1, k) + prices[i];
            int notSell = helper(prices, dp, i+1, 1, transaction, k);
            return dp[i][buyStatus][transaction] = Math.max(sell, notSell);
        }
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k];
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                for(int l=0; l<k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return helper(prices, dp, 0, 0, 0, k);
    }
}