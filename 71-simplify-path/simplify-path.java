class Solution {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> st=new Stack<>();
        for(String ch:words){
            if(ch.equals("") || ch.equals(".")){
                continue;
            }
            else if(ch.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}