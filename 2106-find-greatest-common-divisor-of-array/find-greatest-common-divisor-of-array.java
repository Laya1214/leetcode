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
        
        // using euclidean algorithm-- gcd(a,b)=gcd(b,a%b) until b becomes 0 and the ans will store in a;
        while(min>0){
            int temp=max;
            max=min;
            min=temp%min;
        }
        return max;
    }
}