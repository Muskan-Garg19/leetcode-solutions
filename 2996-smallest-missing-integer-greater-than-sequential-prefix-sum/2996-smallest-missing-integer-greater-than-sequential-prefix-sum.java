class Solution {
    public int missingInteger(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length;i++) {
            max = Math.max(max, nums[i]);
        }

        boolean[] array = new boolean[max+1];

        for(int i=0; i<nums.length; i++) {
            array[nums[i]] = true;
        }

        int i=1;
        int sum = nums[0];
        while(i< nums.length && nums[i] == nums[i-1] + 1) {
            sum+= nums[i];
            i++;
        }

        while(sum<= max && array[sum]) {
            sum++;
        }

        return sum;
    }
}