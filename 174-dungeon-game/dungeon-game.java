class Solution {
    public int calculateMinimumHP(int[][] dung) {
        int row=dung.length;
        int col=dung[0].length;
        int[][] dp=new int[row][col];
        if(dung[row-1][col-1]<0)dp[row-1][col-1]=1-(dung[row-1][col-1]);
        else dp[row-1][col-1]=1;
        for(int i=row-2;i>=0;i--){
            dp[i][col-1]=Math.max(dp[i+1][col-1]-(dung[i][col-1]),1);
        }
        for(int i=col-2;i>=0;i--){
            dp[row-1][i]=Math.max(dp[row-1][i+1]-(dung[row-1][i]),1);
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                 dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dung[i][j], 1);
            }
        }
        return dp[0][0];
    }
}