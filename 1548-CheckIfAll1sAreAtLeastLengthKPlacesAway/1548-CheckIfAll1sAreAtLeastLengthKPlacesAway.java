// Last updated: 7/9/2026, 5:16:21 PM
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