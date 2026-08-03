class Solution {

    int time = 0;

    public void dfs(ArrayList<Integer>[] graph, int curr,
                    boolean[] visited, int[] dt, int[] low,
                    int parent, List<List<Integer>> ans) {

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int neighbour : graph[curr]) {

            if (neighbour == parent)
                continue;

            if (!visited[neighbour]) {

                dfs(graph, neighbour, visited, dt, low, curr, ans);

                low[curr] = Math.min(low[curr], low[neighbour]);

                if (low[neighbour] > dt[curr]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(curr);
                    bridge.add(neighbour);
                    ans.add(bridge);
                }

            } else {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int[] dt = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, dt, low, -1, ans);
            }
        }

        return ans;
    }
}