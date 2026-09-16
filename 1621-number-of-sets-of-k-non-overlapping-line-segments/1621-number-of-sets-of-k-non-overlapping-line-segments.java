class Solution {
    static int M = 1000000007;
    private static int helper(int n, int k, int i, int[][] dp) {
        if(k == 0) {
            return 1;
        }
        if(i >= n) {
            return 0;
        }
        if(dp[i][k] != -1) {
            return dp[i][k];
        }
        long skip = helper(n, k, i+1, dp) % M;
        long take = 0;
        for(int j = i+1; j <= n-1; j++) {
            take += helper(n, k-1, j, dp) % M;
        }
        return dp[i][k] = (int)((skip + take) % M);
    }
    public int numberOfSets(int n, int k) {
        int[][] dp = new int[1001][1001];
        for(int i=0; i<=1000; i++) {
            Arrays.fill(dp[i], -1);
        }
        M = 1000000007;
        return helper(n, k, 0, dp) % M;
    }
}