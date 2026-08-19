class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n * 2];
        int ptr1 = 0;
        int ptr2 = n;
        int j = 0;
        for(int i=0; i<n; i++) {
            ans[j] = nums[ptr1];
            ans[j+1] = nums[ptr2];
            ptr1++;
            ptr2++;
            j+=2; 
        }
        return ans;
    }
}