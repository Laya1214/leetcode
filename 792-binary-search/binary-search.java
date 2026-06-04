class Solution {
    public int bn(int[] nums,int l,int r,int target){
        if(l<r){
            int m=l+(r-l)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target) return bn(nums,m+1,r,target);
            else return bn(nums,l,m,target);
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if(nums.length==0) return 0;
        return bn(nums,0,nums.length,target);
    }
}