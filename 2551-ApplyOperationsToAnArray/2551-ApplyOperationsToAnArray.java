// Last updated: 7/9/2026, 5:09:24 PM
class Solution {
    public int[] applyOperations(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                nums[i] *= 2;
                nums[j] *= 0;
            }
            i++;
            j++;
        }
        i = 0;
        j = 1;
        while(j < nums.length){
            if(nums[i] != 0){
                i++;
            }
            if(nums[j] != 0 && i < j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            else{
                j++;
            }
        }
        return nums;
        
    }
}