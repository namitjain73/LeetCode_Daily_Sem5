// Last updated: 7/9/2026, 5:02:36 PM
class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        int res = 0;
        int ans = 0;
        for(int i = 0 ; i < nums.length-1 ;i++){
            ans += nums[i];
            sum -= nums[i];
            if(Math.abs(ans-sum)%2 == 0) res++;
        }
        return res;
    }
}