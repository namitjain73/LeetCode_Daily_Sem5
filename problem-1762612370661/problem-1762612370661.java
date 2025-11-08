// Last updated: 11/8/2025, 8:02:50 PM
class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums) max = Math.max(max,i);
        int sum = 0;
        for(int i : nums){
            sum += (max - i);
        }
        return sum;
    }
}