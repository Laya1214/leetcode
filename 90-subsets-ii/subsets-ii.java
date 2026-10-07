class Solution {
    public static void solve(List<List<Integer>> res,List<Integer> temp, int i, int[] nums){
        if(i>=nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);//select
        solve(res,temp,i+1,nums);//explore
        temp.remove(temp.size()-1);//backtrack
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i+=1;
        }
        solve(res,temp,i+1,nums);//explore

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
        solve(res,temp,0,nums);
        return res;
    }
}