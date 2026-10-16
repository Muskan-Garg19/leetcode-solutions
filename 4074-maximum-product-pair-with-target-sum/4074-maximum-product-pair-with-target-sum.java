class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int prod = Integer.MIN_VALUE;
        int[] ans = new int[]{-1, -1};
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(Math.abs(nums[i] - nums[j]) != 0 && nums[i] + nums[j] == target && nums[i] * nums[j] > prod) {
                    if(nums[i] > nums[j]) {
                        ans[0] = i;
                        ans[1] = j;
                    }
                    else {
                        ans[0] = j;
                        ans[1] = i;
                    }
                    prod = nums[i] * nums[j];
                }
            }
        }
        return ans;
    }
}