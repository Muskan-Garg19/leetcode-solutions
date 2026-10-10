class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] free = new int[100001];
        for(int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            free[diff]++;
        }
        int k = k1 + k2;
        for(int i = 100000; i > 0 && k > 0; i--) {
            int countOps = Math.min(free[i], k);
            free[i] -= countOps;
            free[i - 1] += countOps;
            k -= countOps;
        }

        long ans = 0;
        for(int i = 0; i <= 100000; i++) {
            if(free[i] != 0) {
                ans += (long) i * i * free[i];
            }
        }

        return ans;
    }
}