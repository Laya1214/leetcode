class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int dif=target-nums[i];
            if(map.containsKey(dif)){
                return new int[]{map.get(dif),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}