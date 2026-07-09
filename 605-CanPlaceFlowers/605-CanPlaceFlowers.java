// Last updated: 7/9/2026, 5:20:45 PM
class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        int c = 0;
        for(int i = 0  ; i < nums.length ; i++){
            if(nums[i] == 0){
                boolean left = (i == 0) || (nums[i-1] ==  0);
                boolean right = (i == nums.length - 1) || ( nums[i+1] == 0);
                if(left && right){
                    c++;
                    nums[i] = 1;
                    if(c >= n) return true;
                }
            }
        }
        return c >= n;
        
    }
}