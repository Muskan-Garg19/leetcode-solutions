class Solution {

    private static int findPar(int[] par,int elem){
        if(par[elem]==elem){
            return elem;
        }

        return par[elem]=findPar(par,par[elem]);
    }

    private static void unionFind(int[] par,int[] rank,int a,int b){
        int parA=findPar(par,a);
        int parB=findPar(par,b);
        if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }
        else if(rank[parB]>rank[parA]){
            par[parA]=parB;
        }
        else {
            par[parB]=parA;
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] rank=new int[n];
        int[] par=new int[n];
        for(int i=0;i<par.length;i++){
            par[i]=i;
        }

        for(int i=1;i<nums.length;i++){
            int first=i-1;
            int sec=i;
            int diff=nums[first]-nums[sec];
            if(Math.abs(diff)<=maxDiff){
                unionFind(par,rank,i-1,i);
            }
        }

        boolean[] ans=new boolean[queries.length];

        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            if(par[a]==par[b]){
                ans[i]=true;
            }
        }

        return ans;
    }
}