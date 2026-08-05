class Solution {

    private static boolean wordSearch(char[][] board, String word, int i, int row, int col, boolean[][] visited) {
        if(i == word.length()-1) {
            return true;
        }

        visited[row][col] = true;
        i++;

        //left
        if(col-1>=0 && !visited[row][col-1] && board[row][col-1] == word.charAt(i)) {
            if(wordSearch(board, word, i, row, col-1, visited)) {
                return true;
            }
        }

        //right
        if(col+1<board[0].length && !visited[row][col+1] && board[row][col+1] == word.charAt(i)) {
            if(wordSearch(board, word, i, row, col+1, visited)) {
                return true;
            }
        }

        //up
        if(row-1>=0 && !visited[row-1][col] && board[row-1][col] == word.charAt(i)) {
            if(wordSearch(board, word, i, row-1, col, visited)) {
                return true;
            }
        }

        //down
        if(row+1<board.length && !visited[row+1][col] && board[row+1][col] == word.charAt(i)) {
            if(wordSearch(board, word, i, row+1, col, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int i=0, j=0;
        for(i=0; i<m; i++) {
            for(j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if(wordSearch(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}