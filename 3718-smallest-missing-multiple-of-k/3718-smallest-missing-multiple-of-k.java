class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], 1);
        }

        int ans = 0;
        int i = k;
        while(map.containsKey(i)) {
            i += k;
        }
        return i;
    }
}