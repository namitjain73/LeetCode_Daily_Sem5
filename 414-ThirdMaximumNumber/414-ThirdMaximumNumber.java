// Last updated: 7/9/2026, 5:21:47 PM
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        long max = Long.MAX_VALUE;
        for(int i = nums.length - 1; i >= 0 ; i--){
            if(max > nums[i]){
                max = (long)nums[i];
                c++;
            }
            if(c == 3){
                
                break;
            }
        }
        if(c != 3){
            max = (long)nums[nums.length-1];
        }

    return (int)max;
        
    }
}