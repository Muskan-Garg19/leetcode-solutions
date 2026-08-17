class Solution {
    private static int helper(int[] nums, int i, int[]dp, int n) {
        if(i >= n) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int include = helper(nums, i+2, dp, n) + nums[i];
        int exclude = helper(nums, i+1, dp, n);
        return dp[i]= Math.max(include, exclude);
    }
    
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int case1 = helper(nums, 0, dp, n-1);
        Arrays.fill(dp, -1);
        int case2 = helper(nums, 1, dp, n);
        return Math.max(case1, case2);
    }
}