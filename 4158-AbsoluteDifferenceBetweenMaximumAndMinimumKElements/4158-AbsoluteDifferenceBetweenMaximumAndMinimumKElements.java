// Last updated: 7/9/2026, 4:57:50 PM
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int sum1 = 0;
        int sum2 = 0;
        int i = 0 ;
        int j = nums.length-1;
        while(k-- > 0){
            sum1 += nums[i++];
            sum2 += nums[j--];
        }
        return Math.abs(sum1 - sum2);
    }
}