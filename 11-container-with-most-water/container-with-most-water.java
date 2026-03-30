class Solution {
    public int maxArea(int[] h) {
        int n=h.length;
        int left=0,right=n-1;
        int max=0;
        while(left<right){
            int width=right-left;
            int height=Math.min(h[left],h[right]);
            int cur=width*height;
            max=Math.max(cur,max);
            if(h[left]<h[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}