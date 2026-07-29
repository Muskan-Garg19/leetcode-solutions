class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0;
        int neg = 0;
        
        int i = 0;
        while(pos < nums.length && neg < nums.length){
            while(pos < nums.length && nums[pos] < 0){
                pos++;
            }
            if(pos < nums.length){
                ans[i] = nums[pos];
                pos++;
                i++;
            }
            while(neg < nums.length && nums[neg] > 0){
                neg++;
            }
            if(neg < nums.length){
                ans[i] = nums[neg];
                neg++;
                i++;
            }
        }

        while(pos < nums.length){
            if(nums[pos] > 0){
                ans[i] = nums[pos];
                i++;
            }
            pos++;
        }

        while(neg < nums.length){
            if(nums[neg] < 0){
                ans[i] = nums[neg];
                i++;
            }
            neg++;
        }

        return ans;
    }
}