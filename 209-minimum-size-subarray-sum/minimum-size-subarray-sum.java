class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int cur=0;
        int res=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            cur+=nums[r];
            while(cur>=target){
                res=Math.min(res,r-l+1);
                cur-=nums[l];
                l++;
            }
        }
        return res!=Integer.MAX_VALUE?res:0;
    }
}