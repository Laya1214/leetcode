class Solution {
    public void dfs(int n, int[][] graph,List<Integer> cur, List<List<Integer>> res){
        if(n==graph.length-1){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int nei:graph[n]){
            cur.add(nei);
            dfs(nei,graph,cur,res);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        cur.add(0);
        dfs(0,graph,cur,res);
        return res;
    }
}