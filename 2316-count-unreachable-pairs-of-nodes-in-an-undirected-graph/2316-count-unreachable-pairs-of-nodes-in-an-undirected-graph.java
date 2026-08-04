class Solution {
    static int count = 0;

    private static void dfs(ArrayList<Integer>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        count++;
        for(int i=0; i<graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i);
            if(!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        long processed = 0;
        long ans = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count = 0;
                dfs(graph, i, visited);
                ans+= (count * processed);
                processed+= count;
            }
        }
        return ans;
    }
}