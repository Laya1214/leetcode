class Solution {
    public int minInsertions(String s) {
        int balance=0;
        int open=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                balance+=2;
                if(balance%2!=0){
                    open++;
                    balance--;
                }
            }
            else{
                if(balance>0 ){
                    balance--;
                }
                else{
                    open+=1;
                    balance+=1;
                }
            }
        }
        return balance+open;
    }
}