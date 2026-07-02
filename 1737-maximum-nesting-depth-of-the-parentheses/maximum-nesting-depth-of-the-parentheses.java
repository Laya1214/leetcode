class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int c=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }
            else{
                if(ch==')')
                st.pop();
            }
            c=Math.max(c,st.size());
        }
        return c;
    }
}