import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {

        if (board == null || board.length == 0) return;

        boolean[][] helper = new boolean[board.length][board[0].length];

        // upper
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O' && !helper[0][j]) {
                helper[0][j] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(0, j));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < board[0].length && board[row][col + 1] == 'O' && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && board[row][col - 1] == 'O' && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && board[row - 1][col] == 'O' && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < board.length && board[row + 1][col] == 'O' && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        // left
        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == 'O' && !helper[i][0]) {
                helper[i][0] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, 0));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < board[0].length && board[row][col + 1] == 'O' && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && board[row][col - 1] == 'O' && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && board[row - 1][col] == 'O' && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < board.length && board[row + 1][col] == 'O' && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        // bottom
        for (int j = 1; j < board[0].length; j++) {
            if (board[board.length - 1][j] == 'O' && !helper[board.length - 1][j]) {
                helper[board.length - 1][j] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(board.length - 1, j));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < board[0].length && board[row][col + 1] == 'O' && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && board[row][col - 1] == 'O' && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && board[row - 1][col] == 'O' && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < board.length && board[row + 1][col] == 'O' && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        // right
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][board[0].length - 1] == 'O' && !helper[i][board[0].length - 1]) {
                helper[i][board[0].length - 1] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, board[0].length - 1));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < board[0].length && board[row][col + 1] == 'O' && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && board[row][col - 1] == 'O' && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && board[row - 1][col] == 'O' && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < board.length && board[row + 1][col] == 'O' && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !helper[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}