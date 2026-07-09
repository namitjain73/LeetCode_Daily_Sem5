// Last updated: 7/9/2026, 5:22:23 PM
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int n : nums){
            if(n <= first) first = n;
            else if(n <= second) second = n;
            else return true;
        }
        return false;
        
    }
}