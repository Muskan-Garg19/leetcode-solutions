class Solution {

    private static int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        int[] arr = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int pos = 0;
        
        while(i<=mid && j<=high) {
            if(nums[i]<= nums[j]) {
                arr[pos] = nums[i];
                i++;
            }
            else {
                arr[pos] = nums[j];
                j++;
            }
            pos++;
        }

        while(i<= mid) {
            arr[pos] = nums[i];
            i++;
            pos++;
        }

        while(j<= high) {
            arr[pos] = nums[j];
            j++;
            pos++;
        }

        for (int k = 0; k < arr.length; k++) {
            nums[low + k] = arr[k];
        }

        return count;
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if(low< high) {
            int mid = low + (high - low) / 2;
            int left = mergeSort(nums, low, mid);
            int right = mergeSort(nums, mid+1, high);
            int pairs = merge(nums, low, mid, high);
            return left + right + pairs;
        }
        return 0;
    }

    public int reversePairs(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        return mergeSort(nums, low, high);
    }
}