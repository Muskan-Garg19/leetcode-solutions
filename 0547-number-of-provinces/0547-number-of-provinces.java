class Solution {

    private static void dfs(ArrayList<Integer>[] graph,int curr,boolean[] visited){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i);
            if(!visited[neighbour]){
                dfs(graph,neighbour,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        
        //creation of the graph
        ArrayList<Integer> [] graph=new ArrayList[isConnected.length+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1){
                    graph[i+1].add(j+1);
                }
            }
        }

        boolean[] visited=new boolean[isConnected.length+1];

        int ans=0;
        for(int i=1;i<graph.length;i++){
            if(!visited[i]){
                ans++;
                dfs(graph,i,visited);
            }
        }

        return ans;
    }
}