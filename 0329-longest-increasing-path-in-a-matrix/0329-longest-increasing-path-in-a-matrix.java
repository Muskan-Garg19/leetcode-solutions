class Solution {
    private static int helper(int[][] matrix, int i, int j, int[][] dp) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;

        //left
        if(j-1 >= 0 && matrix[i][j-1] < matrix[i][j]) {
            left = helper(matrix, i, j-1, dp);
        }

        //right
        if(j+1 < dp[0].length && matrix[i][j+1] < matrix[i][j]) {
            right = helper(matrix, i, j+1, dp);
        }

        //up
        if(i-1 >= 0 && matrix[i-1][j] < matrix[i][j]) {
            up = helper(matrix, i-1, j, dp);
        }

        //down
        if(i+1 < dp.length && matrix[i+1][j] < matrix[i][j]) {
            down = helper(matrix, i+1, j, dp);
        }

        return dp[i][j] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                max = Math.max(max, helper(matrix, i, j, dp));
            }
        }

        return max;
    }
}