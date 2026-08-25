class Solution {
    private static int helper(int[] nums, int start, int end, int[][] dp) {
        if(start+1 == end) {
            return 0;
        }
        if(dp[start][end] != -1) {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=start+1; i<end; i++) {
            int current = nums[start] * nums[i] * nums[end];
            int left = helper(nums, start, i, dp);
            int right = helper(nums, i, end, dp);
            ans = Math.min(ans, (current + left + right));
            dp[start][end] = ans;
        }
        return ans;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(values, 0, n-1, dp);
    }
}