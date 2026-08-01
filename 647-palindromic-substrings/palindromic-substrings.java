class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        if (n <= 1) return 1;
        int c=0;
        int dp[][]=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            c++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                c++;
            }
        }
        for(int l=3;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    c++;
                }
            }
        }
        return c;
    }
}