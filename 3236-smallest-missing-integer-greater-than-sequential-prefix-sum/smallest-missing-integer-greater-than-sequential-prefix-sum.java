class Solution {
    public int missingInteger(int[] nums) {
        int max1=0;int pref=nums[0];
       
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                pref+=nums[i];
            }
            else{
               
                break;
            }
        }
        max1=pref;
        boolean f=false;
        for(int i=0;i<nums.length;i++){
            if(set.contains(max1)){
                max1+=1;
                f=true;
                continue;
            }
        }
        return (f==false)?pref:max1;
    }
}