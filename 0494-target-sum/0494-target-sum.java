class Solution {
    static int ans = 0;
    private static void helper(int[] nums, int target, int n, int sum) {
        if(n < 0) {
            if(sum == target) {
                ans++;
            }
            return;
        }
        helper(nums, target, n-1, sum - nums[n]);
        helper(nums, target, n-1, sum + nums[n]);
        return;
    }
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        int n = nums.length;
        helper(nums, target, n-1, 0);
        return ans;
    }
}