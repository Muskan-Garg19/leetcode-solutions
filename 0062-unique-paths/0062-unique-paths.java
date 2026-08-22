class Solution {
    private static int helper(int row, int col, int[][] dp) {
        if(row == dp.length-1 && col == dp[0].length-1) {
            return 1;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = 0;
        int bottom = 0;
        //rightpaths
        if(col+1 < dp[0].length) {
            right = helper(row, col+1, dp);
        }
        //bottompaths
        if(row+1 < dp.length) {
            bottom = helper(row+1, col, dp);
        }
        return dp[row][col] = right + bottom;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(0, 0, dp);
    }
}