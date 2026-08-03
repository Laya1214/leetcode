class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> v=new HashSet<>();
        q.offer(0);
        v.add(0);
        int vc=1;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int k:rooms.get(cur)){
                if(!v.contains(k)){
                    v.add(k);
                    q.offer(k);
                    vc++;
                }
            }
        }
        return (vc==n);
    }
}