// Last updated: 11/20/2025, 2:54:46 AM
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