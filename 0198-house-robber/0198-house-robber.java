class Solution {
    private static int helper(int[] nums, int i, int[]dp) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int include = helper(nums, i+2, dp) + nums[i];
            int exclude = helper(nums, i+1, dp);
            return dp[i]= Math.max(include, exclude);
        }
    
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i=0; i<n+1; i++) {
            dp[i] = -1;
        }
        return helper(nums, 0, dp);
    }
}