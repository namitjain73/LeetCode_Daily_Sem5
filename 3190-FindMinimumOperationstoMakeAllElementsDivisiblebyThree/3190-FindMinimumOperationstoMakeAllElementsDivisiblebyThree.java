// Last updated: 10/30/2025, 2:24:29 AM
class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int num : nums){
            if(num % 3 != 0) ans++;
        }
        return ans;
    }
}