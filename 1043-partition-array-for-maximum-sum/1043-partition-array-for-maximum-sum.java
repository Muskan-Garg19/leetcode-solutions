class Solution {
    private static int helper(int[] arr, int k, int i, int[] dp) {
        if(i >= arr.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int result = 0;
        int currMax = -1;
        for(int j = i; j < arr.length && j-i+1 <= k; j++) {
            currMax = Math.max(currMax, arr[j]);
            result = Math.max(result, ((j-i+1)*currMax) + helper(arr, k, j+1, dp));
        }
        return dp[i] = result;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(arr, k, 0, dp);
    }
}