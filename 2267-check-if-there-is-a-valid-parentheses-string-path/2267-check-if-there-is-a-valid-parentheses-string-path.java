class Solution {
    private static Boolean[][][] dp;

    private static boolean helper(char[][] grid, int i, int j, int count) {
        count += (grid[i][j] == '(') ? 1 : -1;

        if (count < 0) {
            return false;
        }

        if (dp[i][j][count] != null) {
            return dp[i][j][count];
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return dp[i][j][count] = (count == 0);
        }

        if (i + 1 < grid.length && helper(grid, i + 1, j, count)) {
            return dp[i][j][count] = true;
        }

        if (j + 1 < grid[0].length && helper(grid, i, j + 1, count)) {
            return dp[i][j][count] = true;
        }

        return dp[i][j][count] = false;
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Boolean[m][n][m + n];

        return helper(grid, 0, 0, 0);
    }
}
