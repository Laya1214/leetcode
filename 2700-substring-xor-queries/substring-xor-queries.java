class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int idigit=s.charAt(i)-'0';
            if(idigit==0){
                map.putIfAbsent(0,new int[]{i,i});
                continue;
            }
            int num=0;
            for(int j=i;j<i+31 && j<s.length();j++){
                int digit=s.charAt(j)-'0';
                num*=2;
                num+=digit;
                map.putIfAbsent(num,new int[]{i,j});
            }
        }
        int[][] ans=new int[queries.length][2];
        int i=0;
        for(int[] query:queries){
            int val=query[0]^query[1];
            ans[i++]=map.getOrDefault(val,new int[]{-1,-1});
        }
        return ans;
    }
}