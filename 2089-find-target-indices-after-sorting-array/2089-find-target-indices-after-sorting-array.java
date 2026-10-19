class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if(!map.containsKey(target)) {
            return ans;
        }
        int ind = 0;
        int i = 1;
        while(i < target) {
            if(map.containsKey(i)) {
                ind += map.get(i);
            }
            i++;
        }
        int targetCount = map.get(target);
        for(int j = 0; j < targetCount; j++) {
            ans.add(ind);
            ind++;
        }

        return ans;
    }
}