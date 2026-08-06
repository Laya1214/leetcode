class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            if(!union(u,v)){
                return e;
            }
        }
        return new int[0];
    }
    private int find(int i){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i]);
    }
    private boolean union(int u,int v){
        int u1=find(u);
        int v1=find(v);
        if(u1==v1)return false;
        parent[u1]=v1;
        return true;
    }
}