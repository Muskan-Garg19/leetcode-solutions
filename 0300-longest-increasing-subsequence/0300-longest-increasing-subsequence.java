class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int[] greater = new int[n];
        greater[n-1] = 1;
        int max = 1;
        for(int i=n-2; i>=0; i--) {
            int curr = nums[i];
            int ans = 0;
            int j = i+1;
            while(j < n) {
                if(nums[j] > nums[i]) {
                    ans = Math.max(ans, greater[j]);
                }
                j++;
            }
            greater[i] = ans+1;
            max = Math.max(max, greater[i]);
        }

        return max;
    }
}