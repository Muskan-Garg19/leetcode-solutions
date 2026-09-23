class Solution {
    public int minOperations(int[] nums, int x) {
        int maxLen= -1;
        int left = 0;
        int right = 0;
        int sum = 0;
        int n = nums.length;
        int totalSum = 0;
        for(int i=0; i<n; i++) {
            totalSum += nums[i];
        }
        int target = totalSum - x;
        if(target < 0) {
            return -1;
        }
        while(right < n) {
            sum += nums[right];
            if(sum < target) {
                right++;
            }
            else if(sum == target) {
                maxLen = Math.max(maxLen, (right - left + 1));
                right++;
            }
            else {
                while(left < n && sum > target) {
                    sum -= nums[left];
                    left++;
                }
                if(sum == target) {
                    maxLen = Math.max(maxLen, (right - left + 1));
                }
                right++;
            }
        }
        if(maxLen == -1) {
            return -1;
        }
        return n - maxLen;
    }
}