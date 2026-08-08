class Solution {
    private static int atmost(int[] nums,int k){
        if(k<0)return 0;
        int pref=0;
        int res=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            pref+=nums[i];
            while(pref>k){
                pref-=nums[j];
                j++;
            }
            res+=i-j+1;
        }
        return res;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
}