class Solution {
    public static int ispalindrome(String s,int l,int r){
        int n=s.length();
        int c=0;
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            c++;
            l--;
            r++;
        }
        return c;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            count+=ispalindrome(s,i,i);
            count+=ispalindrome(s,i,i+1);
        }
        return count;
    }
}