class Solution {
    private static boolean isPalin(String s, int i, int j, boolean[][] dp) {
        if(i > j) {
            return true;
        }
        if(dp[i][j]) {
            return true;
        }
        if(s.charAt(i) == s.charAt(j)) {
            return isPalin(s, i+1, j-1, dp);
        }
        else {
            return false;
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int longest = Integer.MIN_VALUE;
        int sp = -1;
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalin(s, i, j, dp)) {
                    dp[i][j] = true;
                    if(j-i+1 > longest) {
                        longest = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+longest);
    }
}