class Solution {
    public int[] dailyTemperatures(int[] temperature) {
        int n=temperature.length;
        int res[]=new int[n];
        Arrays.fill(res,0);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperature[st.peek()]<temperature[i]){
                int prev=st.pop();
                res[prev]=i-prev;
            }
            st.push(i);
        }
        return res;
    }
}