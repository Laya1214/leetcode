class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) result.add(i);
            return result;
        }
        List<Integer>[] graph=new ArrayList[n];
        List<Integer> list=new ArrayList<>();
         for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        int[] in=new int[n];
        for(int[] i:edges){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
            in[i[0]]++;
            in[i[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==1)q.offer(i);
        }
        int r=n;
        while(r>2){
            int s=q.size();
            r-=s;
            for(int i=0;i<s;i++){
                int x=q.poll();
                for(int nei:graph[x]){
                    in[nei]--;
                    if(in[nei]==1)q.offer(nei);
                }
            }
        }
        return new ArrayList<>(q);
    }
}