class Solution {
    private static int helper(int[] coins, int w) {
        int n = coins.length;
        int[][] dp = new int[n+1][w+1];
        
        for(int j=0; j<w+1; j++) {
            dp[0][j] = 0;
        }

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<w+1; j++) {
                //valid
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }

                //invalid
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }


    public int change(int amount, int[] coins) {
        return helper(coins, amount);
    }
}