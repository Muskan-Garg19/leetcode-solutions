class Solution {

    private static int[] find(int n) {
        int[] ans = new int[2];

        if (n == 0) {
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }

        int min = 9;
        int max = 0;

        while (n > 0) {
            int rem = n % 10;
            max = Math.max(max, rem);
            min = Math.min(min, rem);
            n /= 10;
        }

        ans[0] = max;
        ans[1] = min;
        return ans;
    }

    public int maxDigitRange(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxRange = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int[] range = find(nums[i]);
            int diff = range[0] - range[1];
            map.put(i, diff);
            maxRange = Math.max(maxRange, diff);
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.get(i) == maxRange) {
                ans += nums[i];   // Corrected line
            }
        }

        return ans;
    }
}