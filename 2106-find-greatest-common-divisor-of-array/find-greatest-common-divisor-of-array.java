class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        if(n<0)return 0;
        int min=nums[0];
        int max=nums[0];
        for(int i:nums){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }
        for(int i=min;i>0;i--){
            if(min%i==0 && max%i==0){
                return i;
            }
        }
        return 0;
    }
}