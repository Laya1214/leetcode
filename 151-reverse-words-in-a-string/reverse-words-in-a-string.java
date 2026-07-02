class Solution {
    public String reverseWords(String s) {
        Stack<String> st=new Stack<>();
        String[] str=s.split(" ");
        for(int i=0;i<str.length;i++){
            
            if(!str[i].equals("")) st.push(str[i]);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
            
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}