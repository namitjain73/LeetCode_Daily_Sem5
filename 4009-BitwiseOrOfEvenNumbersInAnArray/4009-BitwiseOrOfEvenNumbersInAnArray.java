// Last updated: 7/9/2026, 4:59:01 PM
class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int n = 0;
        for(int i : nums){
            if(i % 2 == 0){
                n |= i;
            }
        }
        return n;
    }
}