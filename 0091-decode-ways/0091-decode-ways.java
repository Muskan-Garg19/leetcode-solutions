class Solution {
    private static int helper(String s, int i, int[] dp) {
        if(i >= s.length()) {
            return 1;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int digit1 = s.charAt(i) - '0';
        if(digit1 == 0) {
            return dp[i] = 0;
        }
        if(i+1 < s.length()) {
            int digit2 = s.charAt(i+1) - '0';
            if(digit1 * 10 + digit2 <= 26) {
                int first = helper(s, i+1, dp);
                int sec = helper(s, i+2, dp);
                return dp[i] = first + sec;
            }
            else {
                return dp[i] = helper(s, i+1, dp);
            }
        }
        return dp[i] = helper(s, i+1, dp);
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
}