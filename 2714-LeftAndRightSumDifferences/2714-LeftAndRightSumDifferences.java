// Last updated: 7/9/2026, 5:08:19 PM
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int sum = 0;
        pre[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--){
            pre[i] = pre[i+1]+nums[i+1];
        }

        post[0] = 0;
        for(int i = 1 ; i < n ; i++){
            post[i] = post[i-1]+nums[i-1];
        }

        for(int i = 0 ; i < n ; i++){
            nums[i] = Math.abs(post[i] - pre[i]);
        }
        return nums;
    }
}