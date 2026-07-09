// Last updated: 7/9/2026, 5:11:24 PM
class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int c = 1;
        int num = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(num == nums[i]) c++;
            else{
                if(c % 2 != 0) return false;
                num = nums[i];
                c = 1;
            }
        }
        return true;
    }
}