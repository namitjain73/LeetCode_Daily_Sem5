// Last updated: 7/9/2026, 5:12:42 PM
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int i : nums) max |= i;
        int c = solve(nums,max,0,0,0);
        return c;
    }
    public int solve(int[] nums , int max , int curr , int i,int c){
        if(i >= nums.length){
            if(curr == max) return 1;
            return 0;
        }

        int n = nums[i];
        int exclude = solve(nums,max,curr,i+1,c);
        int include= solve(nums ,  max , curr | n , i+1 , c);
        return include + exclude;
    }
}