class Solution {
    private static int helper(String word1, String word2, int i, int j, int[][] dp) {
        if(i >= word1.length()) {
            return word2.length() - j;
        }
        if(j >= word2.length()) {
            return word1.length() - i;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = helper(word1, word2, i+1, j+1, dp);
        }
        else {
            int first = helper(word1, word2, i+1, j, dp) + 1;
            int sec = helper(word1, word2, i, j+1, dp) + 1;
            return dp[i][j] = Math.min(first, sec);
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(word1, word2, 0, 0, dp);
    }
}