// Last updated: 7/9/2026, 5:03:50 PM
class Solution {
    public int countValidSelections(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        int curr = 0;
        int res = 0;
        for(int i= 0 ; i < nums.length ; i++){
            curr += nums[i];
            if(nums[i] == 0){
                if(curr == (sum-curr))  res += 2;
                else if(Math.abs(2*curr-sum) == 1) res += 1;
            }
        }
        return res;
    }
}