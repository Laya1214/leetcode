class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)return intervals;
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]> res=new ArrayList<>();
        int[] newInter= intervals[0];
        res.add(newInter);
        for(int[] interval:intervals){
            if(interval[0]<=newInter[1]){
                newInter[1]=Math.max(interval[1],newInter[1]);
            }
            else{
                newInter=interval;
                res.add(newInter);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}