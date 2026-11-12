class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int n = nums.length;
        int incLen = 1;
        int decLen = 1;
        int i = 1;
        while(i < n){
            if(nums[i-1] < nums[i]) {
                incLen++;
            }
            else {
                ans = Math.max(ans, incLen);
                incLen = 1;
            }
            i++;
        }
        ans = Math.max(ans, incLen);

        i = 1;
        while(i < n){
            if(nums[i-1] > nums[i]) {
                decLen++;
            }
            else {
                ans = Math.max(ans, decLen);
                decLen = 1;
            }
            i++;
        }

        ans = Math.max(ans, decLen);
        return ans;
    }
}