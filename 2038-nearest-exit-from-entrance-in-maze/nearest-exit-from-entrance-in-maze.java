class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int er=entrance[0];
        int ec=entrance[1];
        int row=maze.length;
        int col=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{er,ec,0});
        maze[er][ec]='+';
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int cur[]=q.poll();
            int r=cur[0];
            int c=cur[1];
            int step=cur[2];
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nr==row || nc<0 || nc==col || maze[nr][nc]!='.')continue;
                if(nr==0 || nc==0 || nr==row-1 || nc==col-1)return step+1;
                maze[nr][nc]='+';
                q.offer(new int[]{nr,nc,step+1}); 
            }
        }
        return -1;
    }
}