class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list=new ArrayList<>();
        int[] in=new int[n];
        for(List<Integer> i:edges){
            in[i.get(1)]++;
        }
        for(int i=0;i<n;i++){
            if(in[i]==0){
                list.add(i);
            }
        }
        return list;
    }
}