class Solution {
    public static boolean dfs(int c,int d,List<Integer>[] list,Set<Integer> v){
        if(c==d)return true;
        if (!v.add(c)) {
            return false;
        }
        for (int neighbor : list[c]) {
            if (!v.contains(neighbor)) {
                if (dfs(neighbor, d, list, v)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] list=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            list[u].add(v);
            list[v].add(u);
        }
        Set<Integer> v=new HashSet<>();
        return dfs(source,destination,list,v);
    }
}