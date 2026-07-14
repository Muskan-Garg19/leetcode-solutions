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

    public int numEnclaves(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        boolean[][] helper = new boolean[grid.length][grid[0].length];

        // upper
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 1 && !helper[0][j]) {
                helper[0][j] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(0, j));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < grid[0].length && grid[row][col + 1] == 1 && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && grid[row][col - 1] == 1 && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && grid[row - 1][col] == 1 && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < grid.length && grid[row + 1][col] == 1 && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        // left
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == 1 && !helper[i][0]) {
                helper[i][0] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, 0));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < grid[0].length && grid[row][col + 1] == 1 && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && grid[row][col - 1] == 1 && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && grid[row - 1][col] == 1 && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < grid.length && grid[row + 1][col] == 1 && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        // bottom
        for (int j = 1; j < grid[0].length; j++) {
            if (grid[grid.length - 1][j] == 1 && !helper[grid.length - 1][j]) {
                helper[grid.length - 1][j] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(grid.length - 1, j));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < grid[0].length && grid[row][col + 1] == 1 && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && grid[row][col - 1] == 1 && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && grid[row - 1][col] == 1 && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < grid.length && grid[row + 1][col] == 1 && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        // right
        for (int i = 1; i < grid.length - 1; i++) {
            if (grid[i][grid[0].length - 1] == 1 && !helper[i][grid[0].length - 1]) {
                helper[i][grid[0].length - 1] = true;
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, grid[0].length - 1));

                while (!q.isEmpty()) {
                    Pair p = q.remove();
                    int row = p.row;
                    int col = p.col;

                    // right
                    if (col + 1 < grid[0].length && grid[row][col + 1] == 1 && !helper[row][col + 1]) {
                        helper[row][col + 1] = true;
                        q.add(new Pair(row, col + 1));
                    }

                    // left
                    if (col - 1 >= 0 && grid[row][col - 1] == 1 && !helper[row][col - 1]) {
                        helper[row][col - 1] = true;
                        q.add(new Pair(row, col - 1));
                    }

                    // up
                    if (row - 1 >= 0 && grid[row - 1][col] == 1 && !helper[row - 1][col]) {
                        helper[row - 1][col] = true;
                        q.add(new Pair(row - 1, col));
                    }

                    // down
                    if (row + 1 < grid.length && grid[row + 1][col] == 1 && !helper[row + 1][col]) {
                        helper[row + 1][col] = true;
                        q.add(new Pair(row + 1, col));
                    }
                }
            }
        }

        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !helper[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}