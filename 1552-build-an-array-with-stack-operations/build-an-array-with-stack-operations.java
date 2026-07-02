class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> s=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int tl=target.length;
        int tindex=0;
        for(int i=1;i<=n;i++){
            if(tindex==tl){
                break;
            }else{
                if(target[tindex]==i){
                    st.push(i);
                    s.add("Push");
                    tindex++;
                }
                else{
                    st.push(i);
                    st.pop();
                    s.add("Push");
                    s.add("Pop");
                }
            }
        }
        return s;
    }
}