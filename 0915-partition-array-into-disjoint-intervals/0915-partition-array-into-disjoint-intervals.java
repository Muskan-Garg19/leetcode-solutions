class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int greatest = nums[0];
        int ans = 1;
        int i = 1;
        int currGreatest = nums[0];
        while(i < n) {
            while(i < n && nums[i] < greatest) {
                i++;
            }
            ans = i;
            if(i < n) {
                currGreatest = nums[i];
            }
            i++;
            while(i < n && nums[i] >= greatest) {
                currGreatest = Math.max(currGreatest, nums[i]);
                i++;
            }
            if(i < n) {
                ans = i;
                greatest = currGreatest;
            }
            i++;
        }

        return ans;
    }
}