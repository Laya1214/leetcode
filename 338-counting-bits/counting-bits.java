class Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        for(int i=1;i<=n;i++){
            if((i&1)==0)dp[i]=dp[i/2];
            else dp[i]=dp[i/2]+1;
        }
        return dp;
    }
}