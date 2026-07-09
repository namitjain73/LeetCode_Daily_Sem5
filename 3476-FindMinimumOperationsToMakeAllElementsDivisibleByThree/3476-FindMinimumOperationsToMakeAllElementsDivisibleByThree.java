// Last updated: 7/9/2026, 5:04:52 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int num : nums){
            if(num % 3 != 0) ans++;
        }
        return ans;
    }
}