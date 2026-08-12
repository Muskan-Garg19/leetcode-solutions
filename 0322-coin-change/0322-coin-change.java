class Solution {
    private static int helper(int[] coins, int w) {
        int n = coins.length;
        int[][] dp = new int[n+1][w+1];
        
        for(int j=0; j<w+1; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<w+1; j++) {
                //valid
                if(coins[i-1] <= j) {
                    int val = coins[i-1];
                    int include = 0;
                    if(dp[i][j-val] != Integer.MAX_VALUE) {
                        include = 1+ dp[i][j-val];
                    }
                    else {
                        include = dp[i][j-val];
                    }
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.min(include, exclude);
                }

                //invalid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w] ==  Integer.MAX_VALUE ? -1: dp[n][w];
    }


    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount);
    }
}