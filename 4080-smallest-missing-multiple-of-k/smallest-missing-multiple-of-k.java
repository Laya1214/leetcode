class Solution {
    public int missingMultiple(int[] nums, int k) {
        int l=1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(k*l)){
                l++;
            }
            else{
                return k*l;
            }
        }
        return k*l;
    }
}