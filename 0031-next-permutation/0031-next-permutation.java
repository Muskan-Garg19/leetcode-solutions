class Solution {
    private static void reverse(int[] nums, int i, int j) {
        while(i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        for(int i = n-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        int j = n-1;
        while(j >= 0 && nums[j] <= nums[pivot]) {
            j--;
        }
        int temp = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = temp;

        reverse(nums, pivot+1, n-1);

        return;
    }
}