class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int elem = nums[i];
            int sum = 0;
            while(elem > 0) {
                sum += elem % 10;
                if(sum > i) {
                    break;
                }
                else {
                    elem = elem / 10;
                }
            }
            if(sum == i) {
                return i;
            }
        }

        return -1;
    }
}