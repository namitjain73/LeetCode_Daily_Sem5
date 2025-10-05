// Last updated: 10/5/2025, 8:50:28 AM
class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(i % 2 == 0){
                sum += nums[i];
            }else{
                sum -= nums[i];
            }
        }
        return sum;
    }
}