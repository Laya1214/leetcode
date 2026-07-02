import java.util.Stack;
import java.util.List;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
       
        int[] res = new int[n];
        
        
        Stack<Integer> st = new Stack<>();
        
        
        int prevTime = 0;
        
        for (String log : logs) {
            
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);
            
            if (type.equals("start")) {
                if (!st.isEmpty()) {
                    res[st.peek()] += timestamp - prevTime;
                }
                
                st.push(id);
                
                prevTime = timestamp;
            } else { 
                st.pop();
                
                res[id] += timestamp - prevTime + 1;
                
                prevTime = timestamp + 1;
            }
        }
        
        return res;
    }
}
