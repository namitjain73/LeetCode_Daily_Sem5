// Last updated: 7/9/2026, 5:25:15 PM
class Solution {
    public boolean canJump(int[] nums) {
        int rc = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > rc) return false;
            rc = Math.max(i+nums[i] , rc);
        }
        return  true;
        
    }
}