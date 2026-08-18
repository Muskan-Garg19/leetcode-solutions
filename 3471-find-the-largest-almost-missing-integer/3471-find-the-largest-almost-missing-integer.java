class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = left + k - 1;
        HashMap<Integer, Boolean> helper = new HashMap<>();
        while(right < nums.length) {
            for(int i=left; i<= right; i++) {
                if(!helper.containsKey(nums[i])) {
                    map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                }
                helper.put(nums[i], true);
            }
            left++;
            right++;
            helper = new HashMap<>();

        }

        int ans = -1;
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}