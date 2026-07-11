class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        ArrayList<Integer> graph[] =new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited=new boolean[graph.length];
        int ans=0;
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                Stack<Integer> s=new Stack<>();
                while(!q.isEmpty()){
                    int curr=q.remove();
                    if(!visited[curr]){
                        visited[curr]=true;
                        s.push(curr);
                        for(int j=0;j<graph[curr].size();j++){
                            int neigh=graph[curr].get(j);
                            q.add(neigh);
                        }
                    }
                }
                int degree=s.size()-1;
                int flag=1;
                while(!s.isEmpty()){
                    int curr=s.pop();
                    if(graph[curr].size()!=degree){
                        flag=0;
                        break;
                    }
                }
                if(flag==1){
                    ans++;
                }
            }
        }

        return ans;
    }
}