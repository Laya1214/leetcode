class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        if(nums.length==2 && nums[0]==nums[1] && k==2)return nums.length;
        int max=0;
        int l=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i])>k){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}