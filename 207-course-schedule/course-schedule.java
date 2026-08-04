class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
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
            for(int nei:graph[x]){
                in[nei]--;
                if(in[nei]==0)q.offer(nei);
            }
        }
        return cnt==n;
    }
}