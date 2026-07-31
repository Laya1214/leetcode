class Solution {
    public boolean isPalindrome(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String op="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<=s.length();j++){
                String d=s.substring(i,j);
                if(isPalindrome(d)){
                    if(d.length() > op.length()) {
                        op = d;
                    }
                }
            }
        }
        return op;
    }
}