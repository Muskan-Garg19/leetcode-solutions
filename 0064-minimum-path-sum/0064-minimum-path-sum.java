class Solution {
    private static int helper(int[][] grid, int i, int j, int[][] dp, int m, int n) {
        if(i == m-1 && j == n-1) {
            return grid[i][j];
        }
        // right and down
        if(j+1 < n && i+1 < m) {
            int right = 0;
            int down = 0;
            if(dp[i][j+1] != -1) {
                right = dp[i][j+1];
            }
            else {
                right = helper(grid, i, j+1, dp, m, n);
            }
            if(dp[i+1][j] != -1) {
                down = dp[i+1][j];
            }
            else {
                down = helper(grid, i+1, j, dp, m, n);
            }
            return dp[i][j] = Math.min(right, down) + grid[i][j];
        }
        //right
        else if(j+1 < n) {
            if(dp[i][j+1] != -1) {
                return dp[i][j] = dp[i][j+1] + grid[i][j];
            }
            else {
                return dp[i][j] = helper(grid, i, j+1, dp, m, n) + grid[i][j];
            }
        }
        //down
        else {
            if(dp[i+1][j] != -1) {
                return dp[i][j] = dp[i+1][j] + grid[i][j];
            }
            else {
                return dp[i][j] = helper(grid, i+1, j, dp, m, n) + grid[i][j];
            }
        }
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(grid, 0, 0, dp, m, n);
    }
}