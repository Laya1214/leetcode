class Solution {
    public static void solve(List<List<Integer>> res,List<Integer> temp, int i, int n,int k){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i>n){
            return;
        }
        temp.add(i);//select
        solve(res,temp,i+1,n,k);//explore
        temp.remove(temp.size()-1);//backtrack
        solve(res,temp,i+1,n,k);//explore

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(res,temp,1,n,k);
        return res;
    }
}