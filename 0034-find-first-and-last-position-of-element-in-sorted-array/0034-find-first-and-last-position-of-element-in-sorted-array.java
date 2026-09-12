class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int left = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                left = mid;
                high = mid - 1;
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        if(left == -1) {
            return new int[]{-1, -1};
        }

        low = 0;
        high = n-1;
        int right = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                right = mid;
                low = mid + 1;
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return new int[]{left, right};
    }
}