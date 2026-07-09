// Last updated: 7/9/2026, 5:08:02 PM
class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length == 1) return nums[0];
        long res=1;
        int neg = Integer.MIN_VALUE;
        int n = nums.length;
        int zero = 0;

        for(int i= 0 ; i < n  ; i++){
            if(nums[i] > 0){
                res *= nums[i];
            }else if(nums[i] < 0){
                neg = Math.max(neg , nums[i]);
                res *= nums[i];
            }else zero++;
        }

        if(res < 0) res = res / neg;
        if(zero ==  n) return 0;
        if(zero == n-1 && neg != Integer.MIN_VALUE){
            return 0;
        }
        return res;
    }
}