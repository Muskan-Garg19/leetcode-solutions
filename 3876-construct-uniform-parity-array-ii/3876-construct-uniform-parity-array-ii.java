class Solution {
    public boolean uniformArray(int[] nums) {
        int n = nums.length;
        int oddMin = Integer.MAX_VALUE;
        int evenMin = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(nums[i] % 2 == 0) {
                evenMin = Math.min(evenMin, nums[i]);
            }
            else {
                oddMin = Math.min(oddMin, nums[i]);
            }
        }

        boolean odd = true;
        boolean even = true;
        int i = 0;
        while(i < n && odd && even) {
            if(nums[i] % 2 != 0) {
                odd = true;
                if(oddMin == nums[i] || nums[i] - oddMin < 1) {
                    even = false;
                }
            }
            else {
                even = true;
                if(oddMin == nums[i] || nums[i] - oddMin < 1 ) {
                    odd = false;
                }
            }
            i++;
        }

        if(odd) {
            while(i < n) {
                if(nums[i] % 2 == 0) {
                    if(oddMin == nums[i] || nums[i] - oddMin < 1) {
                        return false;
                    }
                }
                i++;
            }
        }

        else if(even) {
            while(i < n) {
                if(nums[i] % 2 != 0) {
                    if(oddMin == nums[i] || nums[i] - oddMin < 1) {
                        return false;
                    }
                }
                i++;
            }
        }

        return true;
    }
}