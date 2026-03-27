class Solution {
    public int[] asteroidCollision(int[] as) {
        Stack<Integer> st=new Stack<>();
        int n=as.length;
        for(int i=0;i<n;i++){
            if(as[i]>0){
                st.push(as[i]);
            }
            else{
                int ast=Math.abs(as[i]);
                while(!st.isEmpty() && st.peek()>0 && as[i] <0){
                    int peek=st.peek();
                    if(ast == peek){
                        st.pop();
                        as[i]=0;
                    }
                    else if(ast > peek){
                        st.pop();
                    }
                    else{
                        as[i]=0;
                    }
                   
                }
                 if(as[i] != 0){
                        st.push(as[i]);
             }
            }
        }
        int[] arr=new int[st.size()];
        int size=st.size();
        for(int i=size-1; i>=0;i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}