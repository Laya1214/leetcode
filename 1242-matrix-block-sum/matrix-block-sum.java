class Solution {
    public int[][] matrixBlockSum(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] pref=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pref[i+1][j+1]=pref[i][j+1]+pref[i+1][j]+matrix[i][j]-pref[i][j];
            }
        }
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(n - 1, i + k);
                int c2 = Math.min(m - 1, j + k);

                 ans[i][j] = pref[r2 + 1][c2 + 1] 
                          - pref[r1][c2 + 1] 
                          - pref[r2 + 1][c1] 
                          + pref[r1][c1];
            }
        }
        return ans;
    }
}