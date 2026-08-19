class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        boolean[] helper = new boolean[n + 1];
        for(int i=0; i<n; i++) {
            int ind = nums[i];
            if(helper[ind]) {
                ans[0] = nums[i];
            }
            else {
                helper[ind] = true;
            }
        }

        for(int i=1; i<n+1; i++) {
            if(!helper[i]) {
                ans[1] = i;
                return ans;
            }
        }

        return ans;
    }
}