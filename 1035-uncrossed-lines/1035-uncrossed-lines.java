class Solution {
    private static int helper(int[] nums1, int[] nums2, int i1, int i2, int[][] dp) {
        if(i1 >= nums1.length || i2 >= nums2.length) {
            return 0;
        }
        if(dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        if(nums1[i1] == nums2[i2]) {
            return dp[i1][i2] = helper(nums1, nums2, i1+1, i2+1, dp) + 1;
        }
        else {
            int first = helper(nums1, nums2, i1+1, i2, dp);
            int sec = helper(nums1, nums2, i1, i2+1, dp);
            return dp[i1][i2] = Math.max(first, sec);
        }
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1][n2];
        for(int i=0; i<n1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums1, nums2, 0, 0, dp);
    }
}