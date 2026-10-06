class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            list.add(new ArrayList<>(Arrays.asList(intervals[i][0],intervals[i][1])));
        }
        int c=0;
        list.sort((a,b)->Integer.compare(a.get(1),b.get(1)));
        int prev=list.get(0).get(1);
        for(int i=1;i<list.size();i++){
            if(list.get(i).get(0)<prev){
                c++;
            }
            else{
                prev=list.get(i).get(1);
            }
        }
        return c;
    }
}