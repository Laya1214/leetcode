class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i:students){
            q.offer(i);
        }
        int i=0;
        while(!q.isEmpty()){
            if (c == q.size()) break;
            if(q.peek()==sandwiches[i]){
                q.poll();
                i++;
                c=0;
                continue;
            }
            else{
                int a=q.poll();
                q.offer(a);
                c++;
            }
            
        }
        
        return q.size();
    }
}