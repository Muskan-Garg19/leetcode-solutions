class Solution {

    private static boolean isBipar(ArrayList<Integer>[] graph,int curr,int[] color){
        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            if(color[neigh]==color[curr]){
                return false;
            }
            if(color[neigh]==-1){
                color[neigh]=1-color[curr];
                if(!isBipar(graph,neigh,color)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<Integer>[] graph= new ArrayList[n+1];
        int[] color=new int[n+1];
        
        for(int i=0;i<=n;i++){
            color[i]=-1;
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<dislikes.length;i++){
            int u=dislikes[i][0];
            int v=dislikes[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(!isBipar(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
}