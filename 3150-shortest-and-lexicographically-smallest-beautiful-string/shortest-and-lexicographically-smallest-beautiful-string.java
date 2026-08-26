class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> list=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                list.add(i);
            }
        }
        int left=0;
        int right=k-1;
        String res="";
        int m=list.size();
        while(right<m){
            String s1=s.substring(list.get(left),list.get(right)+1);
            if(res.isEmpty()){
                res=s1;
            }
            else{
                if(s1.length()<res.length()){
                    res=s1;
                }
                else if(s1.length()==res.length()){
                    int p=s1.length();
                    for(int k1=0;k1<p;k1++){
                        if(s1.charAt(k1)-'0' < res.charAt(k1)-'0'){
                            res=s1;
                            break;
                        }
                        else if(s1.charAt(k1)-'0' > res.charAt(k1)-'0'){
                            break;
                        }
                    }
                }
            }
            left++;
            right++;
        }
        return res;
    }
}