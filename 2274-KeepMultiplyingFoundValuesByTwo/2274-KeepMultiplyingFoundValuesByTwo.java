// Last updated: 7/9/2026, 5:11:44 PM
class Solution {
    public int findFinalValue(int[] nums, int o) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i< n ; i++){
            if(o == nums[i]){
                o = 2*o;
            }
        }
        return o;
    }
}