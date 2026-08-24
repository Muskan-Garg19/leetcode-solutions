class Solution {
    private static int helper(String s, int i, int j, int[][] dp) {
        if(i > j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)) {
            if(i == j) {
                return dp[i][j] = 1;
            }
            else {
                return dp[i][j] = helper(s, i+1, j-1, dp) + 2;
            }
        }
        else {
            int first = helper(s, i+1, j, dp);
            int sec = helper(s, i, j-1, dp);
            return dp[i][j] = Math.max(first, sec);
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(s, 0, s.length()-1, dp);
    }
}