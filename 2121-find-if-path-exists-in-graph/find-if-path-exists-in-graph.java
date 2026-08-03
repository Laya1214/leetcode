class Solution {
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
        Queue<Integer> q=new LinkedList<>();
        q.offer(source);
        v.add(source);
        while(!q.isEmpty()){
            int l=q.size();
            for(int i=0;i<l;i++){
                int x=q.poll();
                if(x==destination)return true;
                
                for(int neighbour:list[x]){
                    if(x==destination)return true;
                    if(!v.contains(neighbour)){
                        v.add(neighbour);
                        q.offer(neighbour);
                    }
                }
            }
        }
        return false;
    }
}