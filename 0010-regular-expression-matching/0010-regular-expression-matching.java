class Solution {
    private static boolean helper(String s, String p, int i, int j, int[][] dp) {
        if(i >= s.length() && j >= p.length()) {
            return true;
        }
        if(j >= p.length()) {
            return false;
        }
        if(dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }
        
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            boolean exclude = helper(s, p, i, j+2, dp);
            boolean include = false;
            char ch = p.charAt(j);
            if(i < s.length() && (ch == '.' || s.charAt(i) == ch)) {
                include = helper(s, p, i+1, j, dp);
            }
            boolean ans = exclude || include;
            dp[i][j] = ans ?  1 : 0;
            return ans;
        }
        else if(i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            boolean ans = helper(s, p, i+1, j+1, dp);
            dp[i][j] = ans ?  1 : 0;
            return ans;
        }
        else {
            dp[i][j] = 0;
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0; i<=n1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(s, p, 0, 0, dp);
    }
}