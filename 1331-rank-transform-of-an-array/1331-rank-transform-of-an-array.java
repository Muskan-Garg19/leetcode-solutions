class Solution {
    class Pair implements Comparable<Pair>{
        int elem;
        int ind;
        Pair(int elem,int ind){
            this.elem=elem;
            this.ind=ind;
        }
        public int compareTo(Pair p){
            return this.elem-p.elem;
        }
    }
    
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i],i));
        }

        int rank=0;
        int prev=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int curr=p.elem;
            int ind=p.ind;
            if(curr!=prev){
                rank++;
            }
            ans[ind]=rank;
            prev=curr;
        }

        return ans;
    }
}