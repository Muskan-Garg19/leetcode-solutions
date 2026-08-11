class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        int i=1;
        int sum = nums[0];
        while(i< nums.length && nums[i] == nums[i-1] + 1) {
            sum+= nums[i];
            i++;
        }

        while(set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}