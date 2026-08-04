class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lowValue = 0 * n + 0;
        int highValue = (m-1) * n + (n-1);
        while(lowValue<= highValue) {
            int midValue = lowValue + (highValue - lowValue) / 2;
            int midRow = midValue / n;
            int midCol = midValue % n;
            int val = matrix[midRow][midCol];
            if(val == target) {
                return true;
            }
            else if(val > target) {
                highValue = midValue-1;
            }
            else {
                lowValue = midValue+1;
            }
        }

        return false;
    }
}