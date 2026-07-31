class Solution {
    
    public String longestPalindrome(String s) {
        
       int n=s.length();
        if (n <= 1) return s;
       int[][] dp=new int[n][n];
       for(int[] row:dp){
            Arrays.fill(row,0);
       }
       int x=0,y=1;
       for(int i=0;i<n;i++){
            dp[i][i]=1;
       }
       
       for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){ dp[i][i+1]=1;x=i;y=2;}
       }
       for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    x=i;y=len;
                }
            }
       }
       return s.substring(x,x+y);
    }
}