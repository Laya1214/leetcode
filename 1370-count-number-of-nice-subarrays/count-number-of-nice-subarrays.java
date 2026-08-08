class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int pref=0;
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pref+=nums[i]%2;
            res+=map.getOrDefault(pref-k,0);
            map.put(pref,map.getOrDefault(pref,0)+1);
        }
        return res;
    }
}