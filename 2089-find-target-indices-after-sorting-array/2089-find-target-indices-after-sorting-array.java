class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int[] map = new int[101];
        for(int i = 0; i < n; i++) {
            map[nums[i]]++;
        }
        int ind = 0;
        int i = 1;
        while(i < target) {
            if(map[i] != 0) {
                ind += map[i];
            }
            i++;
        }
        for(int j = 0; j < map[target]; j++) {
            ans.add(ind);
            ind++;
        }

        return ans;
    }
}