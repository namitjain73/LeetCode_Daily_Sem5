// Last updated: 7/9/2026, 5:26:00 PM
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans =nums[0] + nums[1] + nums[2];
        for(int i = 0 ; i < nums.length-2; i ++){
            int lo = i + 1;
            int hi = nums.length- 1;
            while(lo < hi){
                int sum = nums[i] +nums[lo] + nums[hi];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                } 

                if(sum == target)  {
                    return sum;
                }
                if(sum < target){
                    lo++;
                    
                }
                else{
                    hi --;
                }
            }
        }
        return ans;
    }
}