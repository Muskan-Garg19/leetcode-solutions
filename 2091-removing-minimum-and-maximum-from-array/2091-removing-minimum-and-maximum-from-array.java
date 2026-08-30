class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minInd = 0;
        int maxInd = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] < min) {
                min = nums[i];
                minInd = i;
            }
            if(nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
        }
        int forward = Math.max(minInd, maxInd) + 1;
        int backward = n- Math.min(minInd, maxInd);
        int mixed = Math.min(minInd, maxInd) + 1 + n -Math.max(minInd, maxInd);
        return Math.min(Math.min(forward, backward), mixed);
    }
}