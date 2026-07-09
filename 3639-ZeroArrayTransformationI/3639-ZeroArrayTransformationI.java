// Last updated: 7/9/2026, 5:03:16 PM
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] diff = new int[n];
        for(int i = 0 ; i < m ; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            diff[l]++;
            if(r+1 < n) diff[r+1]--;
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            cnt += diff[i];
            if(nums[i] > cnt) return false;
        }
        return true;
    }
}