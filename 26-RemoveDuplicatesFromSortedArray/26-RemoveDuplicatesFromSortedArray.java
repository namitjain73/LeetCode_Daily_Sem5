// Last updated: 7/9/2026, 5:25:45 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums[0];
        int c = 1;
        for(int i = 1,j=1; i < nums.length ; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                c++;
                j++;
            }
        }
        return c;
        
    }
}