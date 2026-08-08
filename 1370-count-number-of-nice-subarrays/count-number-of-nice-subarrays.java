class Solution {
    private static int atmost(int[] nums,int k){
        if(k<0)return 0;
        int pref=0;
        int res=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            pref+=nums[i]%2;
            while(pref>k){
                pref-=nums[j]%2;
                j++;
            }
            res+=i-j+1;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        
        return atmost(nums,k)-atmost(nums,k-1);
    }
}