class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int i=0;
        while(i<n) {
            int left = i;
            int right = i-1;
            int num = nums[i];
            while(i < n && nums[i] == num) {
                right++;
                i++;
            }
            boolean flag = true;
            for(int j=0; j<left; j++) {
                if(nums[j] == num) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                for(int j=i; j<n; j++) {
                    if(nums[j] == num) {
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                ans++;
            }
        }
        return ans;
    }
}