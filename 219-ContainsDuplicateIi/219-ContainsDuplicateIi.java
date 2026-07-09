// Last updated: 7/9/2026, 5:23:10 PM
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length && Math.abs(i - j) <= k; j++){
                if(nums[i] == nums[j]){
                    // if(Math.abs(i - j) <= k){
                        return true;
                    // }
                }
            }
        }
        return flag;
        
    }
}