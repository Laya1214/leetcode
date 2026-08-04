class Solution {
    public static void dfs(int r,int c,int row,int col,int[][] image,int color,int st){
        if(r<0 || r==row || c<0 || c==col || image[r][c]!=st){return;}
        image[r][c]=color;
        dfs(r+1,c,row,col,image,color,st);
        dfs(r,c+1,row,col,image,color,st);
        dfs(r,c-1,row,col,image,color,st);
        dfs(r-1,c,row,col,image,color,st);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        int x=image[sr][sc];
        if(x==color)return image;
        dfs(sr,sc,row,col,image,color,x);
        return image;
    }
}