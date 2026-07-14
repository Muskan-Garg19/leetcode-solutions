class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int ans=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[i].length;j++){
                if(grid2[i][j] == 1){
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    grid2[i][j]=0;
                    boolean isSubIsland=true;
                    while(!q.isEmpty()){
                        Pair p=q.remove();
                        int row=p.row;
                        int col=p.col;

                        if(grid1[row][col]!=1){
                            isSubIsland=false;
                        }

                        //left
                        if(col-1>=0 && grid2[row][col-1] == 1){
                            q.add(new Pair(row,col-1));
                            grid2[row][col-1]=0;
                        }

                        //right
                        if(col+1<grid2[0].length && grid2[row][col+1] == 1){
                            q.add(new Pair(row,col+1));
                            grid2[row][col+1]=0;
                        }

                        //up
                        if(row-1>=0 && grid2[row-1][col] == 1){
                            q.add(new Pair(row-1,col));
                            grid2[row-1][col]=0;
                        }

                        //down
                        if(row+1<grid2.length && grid2[row+1][col] == 1){
                            q.add(new Pair(row+1,col));
                            grid2[row+1][col]=0;
                        }
                    }

                    if(isSubIsland){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}