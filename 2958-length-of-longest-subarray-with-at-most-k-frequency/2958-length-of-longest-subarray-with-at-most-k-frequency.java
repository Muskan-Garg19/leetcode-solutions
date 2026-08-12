class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        while(right< nums.length) {
            int elem = nums[right];
            int freequency = map.getOrDefault(nums[right], 0);
            if(freequency + 1 <= k) {
                map.put(nums[right], freequency + 1);
                right++;
            }
            else {
                ans = Math.max(ans, right-left);
                map.put(nums[left], map.get(nums[left])-1);
                left++;
            }
        }
        ans = Math.max(ans, right-left);
        return ans;
    }
}