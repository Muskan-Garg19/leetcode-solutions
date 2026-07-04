class Solution {

    class Pair implements Comparable<Pair>{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
        public int compareTo(Pair p){
            return this.wt-p.wt;
        }
    }

    private void dijastra(ArrayList<Pair>[] graph,int i,int[] dist){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(i,0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int u=curr.node;
            for(int j=0;j<graph[u].size();j++){
                Pair next=graph[u].get(j);
                int v=next.node;
                int wt=next.wt;
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int threshold) {

        //creation of the graph
        ArrayList<Pair>[] graph=new ArrayList[n];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            graph[u].add(new Pair(v,wt));
            graph[v].add(new Pair(u,wt));
        }

        int[] dist;
        int ans=0;
        int minVisited=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            dist=new int[n];

            //dist array Initialization
            for(int j=0;j<dist.length;j++){
                if(j!=i){
                    dist[j]=Integer.MAX_VALUE;
                }
            }

            dijastra(graph,i,dist);
            int currVisited=0;

            for(int k=0;k<dist.length;k++){
                if(dist[k]<=threshold){
                    currVisited++;
                }
            }

            if(currVisited<=minVisited){
                ans=i;
                minVisited=currVisited;
            }
        }

        return ans;
    }
}