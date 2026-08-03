class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int[] in=new int[n+2];
        for(int[] i: edges){
            in[i[0]]++;
            in[i[1]]++;
        }
        int op=-1;
        for(int i=1;i<n+2;i++){
            if(in[i]==n){op=i; break;}
        }
        return op;
    }
}