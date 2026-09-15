class Solution {
    private static boolean isPalindrome(String s, int i, int j) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    private static int helper(String s, int k, int i, int j, int[][] dp) {
        if(i >= s.length() || j >= s.length()) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(isPalindrome(s, i, j)) {
            int take = 1 + helper(s, k, j+1, j+k, dp);
            int grow = helper(s, k, i, j+1, dp);
            int slide = helper(s, k, i+1, j+1, dp);
            return dp[i][j] = Math.max(take, Math.max(grow, slide));
        }
        else {
            int grow = helper(s, k, i, j+1, dp);
            int slide = helper(s, k, i+1, j+1, dp);
            return dp[i][j] = Math.max(grow, slide);
        }
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k == 1) {
            return n;
        }
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, k, 0, k-1, dp);
    }
}