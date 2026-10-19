class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < n && nums[i] != target) {
            i++;
        }
        while(i < n && nums[i] == target) {
            ans.add(i);
            i++;
        }

        return ans;
    }
}