class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        int vc=1;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int k:rooms.get(cur)){
                if(!visited[k]){
                    visited[k]=true;
                    q.offer(k);
                    vc++;
                }
            }
        }
        return (vc==n);
    }
}