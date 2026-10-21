class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int[] ans = new int[2];
        int row = 0;
        int col = 0;
        int nextRow = 0;
        int nextCol = 0;
        while(true) {
            char ch = grid[row][col];
            if(ch == 'U') {
                nextRow = row - 1;
                nextCol = col;
            }
            else if(ch == 'R') {
                nextRow = row;
                nextCol = col + 1;
            }
            else if(ch == 'L') {
                nextRow = row;
                nextCol = col - 1;
            }
            else {
                nextRow = row + 1;
                nextCol = col;
            }
            if(nextRow < 0 || nextRow == grid.length || nextCol < 0 || nextCol == grid[0].length || grid[nextRow][nextCol] == 'V') {
                ans[0] = row;
                ans[1] = col;
                break;
            }
            else {
                grid[row][col] = 'V';
                row = nextRow;
                col = nextCol;
            }
        }
        return ans;
    }
}