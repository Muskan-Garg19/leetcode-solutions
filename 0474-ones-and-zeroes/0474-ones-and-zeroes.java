class Solution {
    private static int helper(int[][][] dp, int[][] count, int i, int m, int n) {
        if(m == 0 && n == 0 || i == count.length) {
            return 0;
        }
        if(dp[i][m][n] != -1) {
            return dp[i][m][n];
        }
        if(count[i][0] <= m && count[i][1] <= n) {
            int include = helper(dp, count, i+1, m-count[i][0], n-count[i][1]) + 1;
            int exclude = helper(dp, count, i+1, m, n);
            return dp[i][m][n] = Math.max(include, exclude);
        }
        else {
            return dp[i][m][n] = helper(dp, count, i+1, m, n);
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][] count = new int[size][2];
        for(int i=0; i<size; i++) {
            int zero = 0;
            int one = 0;
            String s = strs[i];
            for(int j=0; j<s.length(); j++) {
                char ch = s.charAt(j);
                if(ch - '0' == 0) {
                    zero++;
                }
                else {
                    one++;
                }
            }
            count[i][0] = zero;
            count[i][1] = one;
        }
        int[][][] dp = new int[size+1][m+1][n+1];
        for(int i=0; i<=size; i++) {
            for(int j=0; j<=m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(dp, count, 0, m, n);
    }
}