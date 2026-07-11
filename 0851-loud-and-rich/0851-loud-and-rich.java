class Solution {

    private static void dfs(ArrayList<Integer>[] graph,int curr,boolean[] visited,int[] ans,int[] quiet){

        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            if(!visited[neigh]){
                dfs(graph,neigh,visited,ans,quiet);
            }
            if (quiet[ans[neigh]] < quiet[ans[curr]]) {
                ans[curr] = ans[neigh];
            }
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<richer.length;i++){
            int a=richer[i][0];
            int b=richer[i][1];
            graph[b].add(a);
        }

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=i;
        }
        
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph,i,visited,ans,quiet);
            }
        }

        return ans;
    }
}