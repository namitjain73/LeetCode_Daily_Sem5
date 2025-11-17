// Last updated: 11/17/2025, 10:49:15 PM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1 && pre == -1){
                pre = i;
            }else if(nums[i] == 1){
                if((i - pre - 1) < k) return false;
                else pre = i;
            }
        }
        return true;
    }
}