class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st=new Stack<>();
        int[] res=prices.clone();
        int n=prices.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]){
                int dis=st.pop();
                res[dis]-=prices[i];
            }
            st.push(i);
           
        }
        return res;
    }
}