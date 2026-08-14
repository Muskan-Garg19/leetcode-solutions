class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int ans = 0;
        int count = 0;
        int diff = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                count++;
                ans += count;
            } else {
                diff = nums[i] - nums[i - 1];
                count = 0;
            }
        }

        return ans;
    }
}