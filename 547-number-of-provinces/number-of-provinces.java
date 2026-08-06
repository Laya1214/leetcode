class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        int p=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                p++;
            }
        }
        return p;
    }
    private int find(int i){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i]);
    }
    private void union(int u,int v){
        int u1=find(u);
        int v1=find(v);
        if(u1==v1)return;
        parent[u1]=v1;
        return;
    }
}