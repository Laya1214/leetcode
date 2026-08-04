class Solution {
    public static void dfs(int r,int c,int row,int col, char[][] grid,boolean[][] visited){
        if(r<0 || r==row || c<0 ||c==col || grid[r][c]=='0' || visited[r][c]==true)return;
        visited[r][c]=true;
        dfs(r+1,c,row,col,grid,visited);
        dfs(r,c+1,row,col,grid,visited);
        dfs(r-1,c,row,col,grid,visited);
        dfs(r,c-1,row,col,grid,visited);
    }
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    count+=1;
                    dfs(i,j,row,col,grid,visited);
                }
            }
        }
        return count;
        
    }
}