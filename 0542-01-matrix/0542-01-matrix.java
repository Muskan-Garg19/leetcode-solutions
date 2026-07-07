class Solution {

    class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int[][] ans = new int[mat.length][mat[0].length];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = -1;

                if (mat[i][j] == 0) {
                    ans[i][j] = 0;              // Mark visited
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {

            Pair p = q.remove();

            int x = p.x;
            int y = p.y;
            int dist = p.dist;

            // left
            if (y - 1 >= 0 && ans[x][y - 1] == -1) {
                ans[x][y - 1] = dist + 1;
                q.add(new Pair(x, y - 1, dist + 1));
            }

            // right
            if (y + 1 < mat[0].length && ans[x][y + 1] == -1) {
                ans[x][y + 1] = dist + 1;
                q.add(new Pair(x, y + 1, dist + 1));
            }

            // up
            if (x - 1 >= 0 && ans[x - 1][y] == -1) {
                ans[x - 1][y] = dist + 1;
                q.add(new Pair(x - 1, y, dist + 1));
            }

            // down
            if (x + 1 < mat.length && ans[x + 1][y] == -1) {
                ans[x + 1][y] = dist + 1;
                q.add(new Pair(x + 1, y, dist + 1));
            }
        }

        return ans;
    }
}