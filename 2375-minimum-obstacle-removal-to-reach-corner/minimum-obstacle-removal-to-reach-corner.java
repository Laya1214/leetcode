class Solution {
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        int maxi=Integer.MAX_VALUE;
        for(int[] row:dp){
            Arrays.fill(row,maxi);
        }
        dp[0][0]=0;
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        Deque<int[]> q=new ArrayDeque<>();
        q.addLast(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur=q.removeFirst();
            int r=cur[0];
            int c=cur[1];
           // if(r==n-1 && c==m-1)return dp[n-1][m-1];
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nr==n || nc<0 || nc==m)continue;
                int cost=grid[nr][nc];
                
                if(dp[r][c]+cost < dp[nr][nc]){
                    dp[nr][nc]=dp[r][c]+cost;
                    if(cost==0)q.addFirst(new int[]{nr,nc});
                    if(cost==1)q.addLast(new int[]{nr,nc});
                }
                
                
            }
        }
        return dp[n-1][m-1];
    }
}