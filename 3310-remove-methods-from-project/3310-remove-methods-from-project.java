class Solution {

    private static boolean dfs(ArrayList<Integer>[] graph, int curr, boolean[] visited, ArrayList<Integer> list, boolean[] group) {
        visited[curr] = true;
        list.add(curr);
        for(int i=0; i<graph[curr].size(); i++) {
            int neighbour = graph[curr].get(i);
            if(group[neighbour]) {
                return false;
            }
            if(!visited[neighbour]) {
                boolean isDfs = dfs(graph, neighbour, visited, list, group);
                if(!isDfs) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];
            graph[u].add(v);
        }

        boolean[] visited = new boolean[n];
        boolean[] group = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        boolean isDfs = dfs(graph, k, visited, list, group);
        if(isDfs) {
            for(int i=0; i<list.size(); i++) {
                int elem = list.get(i);
                group[elem] = true;
            }
        }
        
        for(int i=0; i<n; i++) {
            if(!visited[i] && i!=k) {
                if(!dfs(graph, i, visited, new ArrayList<>(), group)) {
                    for(int j=0; j<group.length; j++) {
                        ans.add(j);
                    }
                    return ans;
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(!group[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}