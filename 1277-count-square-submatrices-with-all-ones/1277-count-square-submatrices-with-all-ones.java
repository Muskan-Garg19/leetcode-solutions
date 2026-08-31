class Solution {
    private static int helper(int[][] matrix, int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 1) {
                    if(i-1 >=0 && j-1 >=0) {
                        arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]),arr[i-1][j-1]) + 1;
                    }
                    else {
                        arr[i][j] = 1;
                    }
                    ans += arr[i][j];
                }
            }
        }
        return ans;
    }
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        return helper(matrix, arr);
    }
}