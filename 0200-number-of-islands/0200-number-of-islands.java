class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public int numIslands(char[][] grid) {
        
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]-'0' == 1){
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        Pair p=q.remove();
                        int row=p.row;
                        int col=p.col;

                        //left
                        if(col-1>=0 && grid[row][col-1]-'0' == 1){
                            q.add(new Pair(row,col-1));
                            grid[row][col-1]='0';
                        }

                        //right
                        if(col+1<grid[0].length && grid[row][col+1]-'0' == 1){
                            q.add(new Pair(row,col+1));
                            grid[row][col+1]='0';
                        }

                        //up
                        if(row-1>=0 && grid[row-1][col]-'0' == 1){
                            q.add(new Pair(row-1,col));
                            grid[row-1][col]='0';
                        }

                        //down
                        if(row+1<grid.length && grid[row+1][col]-'0' == 1){
                            q.add(new Pair(row+1,col));
                            grid[row+1][col]='0';
                        }
                    }

                    ans++;
                }
            }
        }

        return ans;
    }
}