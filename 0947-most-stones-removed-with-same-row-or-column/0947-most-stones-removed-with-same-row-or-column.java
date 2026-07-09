class Solution {

    private static void dfs(ArrayList<Integer>[] graph,int curr,boolean[] visited){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            if(!visited[neigh]){
                dfs(graph,neigh,visited);
            }
        }
    }

    public int removeStones(int[][] stones) {

        ArrayList<Integer>[] graph=new ArrayList[stones.length];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<stones.length;i++){
            int row=stones[i][0];
            int col=stones[i][1];
            for(int j=i+1;j<stones.length;j++){
                int row2=stones[j][0];
                int col2=stones[j][1];
                if(row==row2 || col==col2){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        int ans=0;

        boolean[] visited=new boolean[stones.length];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                ans++;
                dfs(graph,i,visited);
            }
        }

        return stones.length-ans;
    }
}