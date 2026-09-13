class Solution {
    private static int countOverlaps(int[][] A, int[][] B, int rowOff, int colOff) {
        int count = 0;
        int n = A.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int B_i = i + rowOff;
                int B_j = j + colOff;
                if(B_i < 0 || B_i >= n || B_j < 0 || B_j >= n) {
                    continue;
                }
                if(A[i][j] == 1 && B[B_i][B_j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n  = img1.length;
        int maxOverlap = 0;
        for(int rowOff = -n+1; rowOff < n; rowOff++) {
            for(int colOff = -n+1; colOff < n; colOff++) {
                int count = countOverlaps(img1, img2, rowOff, colOff);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }

        return maxOverlap;
    }
}