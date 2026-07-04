class Solution {

    class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        public int compareTo(Pair p){
            return this.cost-p.cost;
        }
    }

    public int minScore(int n, int[][] roads) {
        
        //graph creation
        ArrayList<Pair>[] graph=new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int cost=roads[i][2];
            graph[u].add(new Pair(v,cost));
            graph[v].add(new Pair(u,cost));
        }

        int[] dist=new int[n+1];
        for(int i=0;i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(1,Integer.MAX_VALUE));

        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int node=p.node;
            int cost=p.cost;
            for(int i=0;i<graph[node].size();i++){
                Pair p1=graph[node].get(i);
                int neighbour=p1.node;
                int wt=p1.cost;
                int min=Math.min(wt,cost);
                if(min<dist[neighbour]){
                    dist[neighbour]=min;
                    pq.add(new Pair(neighbour,min));
                }
            }
        }

        return dist[n];
    }
}