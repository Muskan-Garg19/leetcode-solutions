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

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Pair>[] graph=new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int wt=times[i][2];
            graph[u].add(new Pair(v,wt));
        }

        int[] dist=new int[n+1];
        for(int i=0;i<dist.length;i++){
            if(i!=k){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int u=p.node;
            for(int i=0;i<graph[u].size();i++){
                Pair neigh=graph[u].get(i);
                int v=neigh.node;
                int wt=neigh.wt;
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;
    }
}