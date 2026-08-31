class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] - '0' == 0) {
                    continue;
                }
                else {
                    //up valid, left valid && top left corner valid
                    if(i-1 >=0 && j-1 >= 0) {
                        int up = matrix[i-1][j] - '0';
                        int left = matrix[i][j-1] - '0';
                        int corner = matrix[i-1][j-1] - '0';
                        int min = Math.min(Math.min(up, left), corner) + 1;
                        max = Math.max(max, min);
                        matrix[i][j] = (char) ('0' + min);
                    }
                    else {
                        max = Math.max(max, 1);
                    }
                }
            }
        }
        return max * max;
    }
}