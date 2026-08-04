class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        int x=image[sr][sc];
        if(x==color)return image;
        image[sr][sc]=color;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{sr,sc});
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int l=q.size();
            for(int i=0;i<l;i++){
                int cur[] =q.poll();
                int r=cur[0];
                int c=cur[1];
                for(int[] d:dir){
                    int nR=r+d[0];
                    int nC=c+d[1];
                    if(nR>=0 && nR<row && nC>=0 && nC<col && image[nR][nC]==x){
                        image[nR][nC]=color;
                        q.offer(new int[]{nR,nC});
                    }
                }
            }
        }
        return image;
    }
}