class MinStack {
    Stack<Integer> st;
    Stack<Integer> mini;
    public MinStack() {
        st=new Stack<>();
        mini=new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(mini.isEmpty()){
            mini.push(st.peek());
        }else{
            if(value<=mini.peek()){
                mini.push(value);
            }
        }
    }
    
    public void pop() {

        int a=st.pop();
        if(a==mini.peek()){
            mini.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mini.peek();
       
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */