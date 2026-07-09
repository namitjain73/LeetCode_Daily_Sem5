// Last updated: 7/9/2026, 5:00:58 PM
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int i : nums) sum += i;
        return sum % k;
    }
}