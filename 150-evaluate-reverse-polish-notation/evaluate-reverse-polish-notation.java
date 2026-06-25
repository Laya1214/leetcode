class Solution {
    public int evalRPN(String[] s) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length;i++){
            if(s[i].equals("+")){
                st.push(st.pop()+st.pop());
            }
            else if(s[i].equals("-")){
                int b = st.pop(); 
                int a = st.pop(); 
                st.push(a - b);
            }
            else if(s[i].equals("*")){
                st.push(st.pop()*st.pop());
            }
            else if(s[i].equals("/")){
                int b = st.pop(); 
                int a = st.pop(); 
                st.push(a / b);
            }
            else{
                st.push(Integer.parseInt(s[i]));
            }
        }
        return st.peek();
    }
}