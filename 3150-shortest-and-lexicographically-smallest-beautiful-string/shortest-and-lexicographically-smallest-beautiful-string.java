class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                list.add(i);
            }
        }
        int left=0;
        int right=k-1;
        String res="";
        while(right<list.size()){
            String s1=s.substring(list.get(left),list.get(right)+1);
            if(res.isEmpty()){
                res=s1;
            }
            else{
                if(s1.length()<res.length()){
                    res=s1;
                }
                else if(s1.length()==res.length()){
                    for(int k1=0;k1<s1.length();k1++){
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