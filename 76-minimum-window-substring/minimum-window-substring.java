class Solution {
    private static boolean contains(int[] mapS,int[] mapT){
        for(int i=0;i<256;i++){
            if(mapT[i]>mapS[i])return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int[] mapS=new int[256];
        int[] mapT=new int[256];
        int l=0,r=0,minlen=Integer.MAX_VALUE,minstart=0;
        for(char ch:t.toCharArray())mapT[ch]++;
        for(;r<s.length();r++){
            mapS[s.charAt(r)]++;
            while(contains(mapS,mapT)){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    minstart=l;
                }
                mapS[s.charAt(l++)]--;
            }

        }
        return minlen==Integer.MAX_VALUE?"":s.substring(minstart,minstart+minlen);
    }
}