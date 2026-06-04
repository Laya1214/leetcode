class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if(right==0 && nums[0]==target)return 0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)return mid;
            else{
                if(nums[mid]>target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return -1;
    
    }
}