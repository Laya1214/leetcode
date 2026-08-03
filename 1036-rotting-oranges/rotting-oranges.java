class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int oneC=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2)q.offer(new int[]{i,j});
                if(grid[i][j]==1)oneC+=1;
            }
        }
        if (oneC == 0) return 0;
        int count=0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty() && oneC>0){
            int l=q.size();
            count+=1;
            for(int i=0;i<l;i++){
                int[] cur=q.poll();
                int r=cur[0];
                int c=cur[1];
                for(int[] d:dir){
                    int nR=r+d[0];
                    int nC=c+d[1];
                    if (nR >= 0 && nR < rows && nC >= 0 && nC < cols && grid[nR][nC] == 1) {
                        grid[nR][nC] = 2; 
                        oneC -= 1; 
                        q.offer(new int[]{nR, nC}); 
                    }
                }
            }
        }
        return (oneC==0)?count:-1;
    }
}