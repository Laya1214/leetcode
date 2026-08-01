class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;
         if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[][] dp=new int[r+1][c+1];
        dp[0][1] = 1; 
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(obstacleGrid[i-1][j-1]==0){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[r][c];
    }
}