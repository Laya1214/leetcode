class Solution {
    public static void solve(List<List<Integer>> res,List<Integer> temp, int i, int[] nums){
        if(i>=nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(res,temp,i+1,nums);
        temp.remove(temp.size()-1);
        solve(res,temp,i+1,nums);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(res,temp,0,nums);
        return res;
    }
}