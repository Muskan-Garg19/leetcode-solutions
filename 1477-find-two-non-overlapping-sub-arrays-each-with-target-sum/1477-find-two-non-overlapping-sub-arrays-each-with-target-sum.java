class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minInd = new int[n];
        Arrays.fill(minInd, Integer.MAX_VALUE);
        int i = 0;
        int j = 0;
        int result = Integer.MAX_VALUE;
        int currSum = 0;
        int min  = Integer.MAX_VALUE;
        int len = 0;
        while(j < n) {
            currSum += arr[j];
            while(i < j && currSum > target) {
                currSum -= arr[i];
                i++;
            }
            if(currSum == target) {
                len = j-i+1;
                if(i > 0 && minInd[i-1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minInd[i-1]);
                }
                min = Math.min(min, len);
            }
            minInd[j] = min;
            j++;
        }

        if(result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }
}