// Last updated: 7/9/2026, 5:08:57 PM
class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for(int i : nums){
            if(i < 0) neg++;
            else if(i > 0) pos++;
        }

        return Math.max(neg , pos);
        
    }
}