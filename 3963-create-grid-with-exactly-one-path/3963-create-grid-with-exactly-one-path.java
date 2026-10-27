class Solution {
    private static void helper(char[][] arr, int i, int j) {
        if (i < 0 || j < 0) {
            return;
        }

        arr[i][j] = '.';

        if (i > 0) {
            helper(arr, i - 1, j);
        } else if (j > 0) {
            helper(arr, i, j - 1);
        }
    }

    public String[] createGrid(int m, int n) {
        char[][] arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], '#');
        }

        helper(arr, m - 1, n - 1);

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(arr[i]);
        }

        return ans;
    }
}