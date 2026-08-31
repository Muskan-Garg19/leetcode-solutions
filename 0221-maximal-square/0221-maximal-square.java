class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] - '0' == 0) {
                    arr[i][j] = 0;
                }
                else {
                    //up valid, left valid && top left corner valid
                    if(i-1 >=0 && j-1 >= 0) {
                        arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]),arr[i-1][j-1]) + 1;
                        max = Math.max(max, arr[i][j]);
                    }
                    else {
                        arr[i][j] = 1;
                        max = Math.max(max, arr[i][j]);
                    }
                }
            }
        }
        return max * max;
    }
}