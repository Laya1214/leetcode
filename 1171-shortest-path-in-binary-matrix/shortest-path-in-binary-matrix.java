class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(grid[0][0]==1 || grid[row-1][col-1]==1)return -1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0]=1;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
        while(!q.isEmpty()){
            int cur[]=q.poll();
            int r=cur[0];
            int c=cur[1];
            int step=cur[2];
            if( r==row-1 && c==col-1)return step;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nr==row || nc<0 || nc==col || grid[nr][nc]!=0)continue;
                grid[nr][nc]=1;
                q.offer(new int[]{nr,nc,step+1}); 
            }
        }
        return -1;
    }
}