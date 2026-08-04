class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
        List<Integer> res=new ArrayList<>();
        int n=numCourses;
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        int[] in=new int[numCourses];
        for(int[] i:prerequisites){
            graph[i[1]].add(i[0]);
            in[i[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int x=q.poll();
            cnt++;
            res.add(x);
            for(int nei:graph[x]){
                in[nei]--;
                if(in[nei]==0)q.offer(nei);
            }
        }
        return (cnt==n)?res.stream().mapToInt(i -> i).toArray():new int[0];
    }
}