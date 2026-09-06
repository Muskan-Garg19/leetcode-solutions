class Solution {
    private static int helper(String s, String t, int i, int j, int[][] dp) {
        if(j >= t.length()) {
            return 1;
        }
        else if(i >= s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)) {
            int include = helper(s, t, i+1, j+1, dp);
            int exclude = helper(s, t, i+1, j, dp);
            return dp[i][j] = include + exclude;
        }
        else {
            return dp[i][j] = helper(s, t, i+1, j, dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, t, 0, 0, dp);
    }
}