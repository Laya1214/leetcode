class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();
        int index = 0;
        int c = 0; 
        for(int i : tickets){
            q.offer(new int[]{index, i});
            index++;
        }
        
        while(!q.isEmpty()){
            int[] person = q.poll(); 
            c++;                     
            person[1]--;             
            
            
            if (person[0] == k && person[1] == 0) {
                return c;
            }
            
            
            if (person[1] > 0) {
                q.offer(person);
            }
        }
        
        return c;
    }
}
