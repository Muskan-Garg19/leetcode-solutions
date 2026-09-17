class Solution {
    private static int helper(List<Integer> nums, int target, int sum, int i, int[][] dp) {
        if(i >= nums.size()) {
            if(sum == target) {
                return 0;
            }
            else {
                return -1;
            }
        }
        if(dp[i][sum] != -2) {
            return dp[i][sum];
        }
        if(sum + nums.get(i) <= target) {
            int include = helper(nums, target, sum + nums.get(i), i+1, dp);
            if(include != -1) {
                include++;
            }
            int exclude = helper(nums, target, sum, i+1, dp);
            return dp[i][sum] = Math.max(include, exclude);
        }
        else {
            return dp[i][sum] = helper(nums, target, sum, i+1, dp);
        }
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n+1][target+1];
        for(int i=0; i<n+1; i++) {
            Arrays.fill(dp[i], -2);
        }
        return helper(nums, target, 0, 0, dp);
    }
}