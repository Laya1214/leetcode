class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i< nums.length -2 ; i++){
            int start = nums[i];
            int left = i+1;
            int right = nums.length -1;

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            while(left<right){
                int sum = nums[left] + nums[right] + start;

                if(sum>0){
                    right--;
                } else if (sum<0){
                    left++;
                } else{ //equal
                    List<Integer> each = new ArrayList<>();

                    each.add(start);
                    each.add(nums[left]);
                    each.add(nums[right]);
                    ans.add(each);

                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return ans;
    }
}