// Last updated: 7/9/2026, 4:59:07 PM
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int  min =Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }

        return (long)((long)max - (long)min) * (long)k;
    }
}