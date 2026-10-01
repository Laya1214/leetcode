class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int l=0,r=0;
        StringBuilder s1=new StringBuilder();
        while(l<n && r<m){
            s1.append(word1.charAt(l));
            l++;
            s1.append(word2.charAt(r));
            r++;
        }
        while(l<n){
            s1.append(word1.charAt(l));
            l++;
        }
        while(r<m){
            s1.append(word2.charAt(r));
            r++;
        }
        return s1.toString();
    }
}