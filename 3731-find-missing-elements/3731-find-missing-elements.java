class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
            map.put(nums[i], 1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=smallest+1; i<largest; i++) {
            if(!map.containsKey(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}