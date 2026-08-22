class Solution {
    private static int helper(int[][] grid, int row, int col, int[][] dp) {
        if(row == dp.length-1 && col == dp[0].length-1 && grid[row][col] != 1) {
            return 1;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = 0;
        int bottom = 0;
        //rightpaths
        if(col+1 < dp[0].length && grid[row][col+1] != 1) {
            right = helper(grid, row, col+1, dp);
        }
        //bottompaths
        if(row+1 < dp.length && grid[row+1][col] != 1) {
            bottom = helper(grid, row+1, col, dp);
        }
        return dp[row][col] = right + bottom;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(obstacleGrid, 0, 0, dp);
    }
}