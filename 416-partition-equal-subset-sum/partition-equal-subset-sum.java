class Solution {
    public static int sum(int[] n){
        int sum=0;
        for(int i=0;i<n.length;i++){
            sum+=n[i];
        }
        return sum;
    }
    public boolean canPartition(int[] nums) {
        int s=sum(nums);
        if(s % 2 !=0)return false;
        
        int t= s/2;
        boolean[] dp=new boolean[t+1];
        dp[0]=true;
        for(int n:nums){
            for(int j=t;j>=n;j--){
                dp[j]=dp[j] || dp[j-n];
            }
            if(dp[t])return true;
        }
        
        return dp[t];
    }
}