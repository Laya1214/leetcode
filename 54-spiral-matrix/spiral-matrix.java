class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       int n=matrix.length;
       int m=matrix[0].length;
       List<Integer> list=new ArrayList<>();
       int l=0;
       int top=0;
       int r=m-1;
       int b=n-1;
       while(l<=r && top<=b){
        for(int i=l;i<=r;i++){
            list.add(matrix[top][i]);
        }
        top+=1;
        
        for(int i=top;i<=b;i++){
            list.add(matrix[i][r]);
        }
        r-=1;
        if(top<=b){
        for(int i=r;i>=l;i--){
            list.add(matrix[b][i]);
        }}
        b-=1;
        if(l<=r){
        for(int i=b;i>=top;i--){
            list.add(matrix[i][l]);
        }l+=1;
       }} 
       return list;
    }
}