class Solution {
    private static Boolean[][] dp;
    private static boolean canPartition(int[] nums, int n, int sum1, int sum2) {
        if (n == 0) {
            return sum1 == sum2;
        }
         if (dp[n][sum1] != null) {
            return dp[n][sum1];
        }

        boolean include = canPartition(nums, n - 1, sum1 + nums[n - 1], sum2);

        boolean exclude = canPartition(nums, n - 1, sum1, sum2 + nums[n - 1]);

        return dp[n][sum1] = include || exclude;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0; i<n; i++) {
            total+= nums[i];
        }
        dp = new Boolean[n+1][total+1];
        return canPartition(nums, n, 0, 0);
    }
}