class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> s=new ArrayList<>();
        
        int tl=target.length;
        int tindex=0;
        for(int i=1;i<=n;i++){
            if(tindex==tl){
                break;
            }else{
                if(target[tindex]==i){
                   
                    s.add("Push");
                    tindex++;
                }
                else{
                    
                    s.add("Push");
                    s.add("Pop");
                }
            }
        }
        return s;
    }
}