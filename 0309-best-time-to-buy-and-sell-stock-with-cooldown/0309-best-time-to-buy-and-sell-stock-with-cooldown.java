class Solution {
    private static int helper(int[] prices, int i, int buyStatus, int last, int[][][] dp) {
        if(i == prices.length) {
            return 0;
        }
        if(dp[i][buyStatus][last] != -1) {
            return dp[i][buyStatus][last];
        }
        int ans = 0;
        if(buyStatus == 0) {
            if(last != 1) {
                int buy = helper(prices, i+1, 1, 0, dp) - prices[i];
                int notBuy = helper(prices, i+1, 0, 0, dp);
                ans = Math.max(buy, notBuy);
            }
            else {
                ans = helper(prices, i+1, 0, 0, dp);
            }
        }
        else {
            int sell = helper(prices, i+1, 0, 1, dp) + prices[i];
            int notSell = helper(prices, i+1, 1, 0, dp);
            ans = Math.max(sell, notSell);
        }
        return dp[i][buyStatus][last] = ans;
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

        return helper(prices, 0, 0, 0, dp);
    }
}