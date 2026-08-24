class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        
        increasing[0] = 1;
        decreasing[n-1] = 1;
        for(int i=1; i<n; i++) {
            int ans = 0;
            for(int j=i-1; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    ans = Math.max(ans, increasing[j]);
                }
            }
            increasing[i] = ans + 1;
        }

        for(int i=n-2; i>=0; i--) {
            int ans = 0;
            for(int j=i+1; j<n; j++) {
                if(nums[j] < nums[i]) {
                    ans = Math.max(ans, decreasing[j]);
                }
            }
            decreasing[i] = ans + 1;
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            int a = increasing[i];
            int b = decreasing[i];
            if(a > 1 && b > 1)
            max = Math.max(max, (a + b - 1));
        }
        return n - max;
    }
}