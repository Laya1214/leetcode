class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (p1, p2) -> p1[1] - p2[1]);
        int prev=intervals[0][1];
        int c=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prev){
                c++;
            }
            else{
                prev=intervals[i][1];
            }
        }
        return c;
    }
}