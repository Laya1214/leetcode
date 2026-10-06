class Solution {
    public int minAddToMakeValid(String s) {
        int b=0;
        int open=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                b+=1;
            }
            if(ch==')'){
                if(b==0){
                    open+=1;
                }
                else{
                    b-=1;
                }
            }
        }
        return open+b;
    }
}