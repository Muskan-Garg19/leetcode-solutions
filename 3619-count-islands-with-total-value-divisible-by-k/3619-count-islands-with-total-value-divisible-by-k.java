class Solution {
    private static void dfs(int[][] grid, long[] sum, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) {
            return;
        }
        
        sum[0] += grid[i][j];
        grid[i][j] = 0;
        //left
        dfs(grid, sum, i, j-1);
        //right
        dfs(grid, sum, i, j+1);
        //up
        dfs(grid, sum, i-1, j);
        //down
        dfs(grid, sum, i+1, j);
        
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        long[] sum = new long[1];
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    sum[0] = 0;
                    dfs(grid, sum, i, j);
                    if(sum[0] % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}