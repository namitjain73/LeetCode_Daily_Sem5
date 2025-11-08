// Last updated: 11/8/2025, 8:24:03 PM
class Solution {
    public int countMajoritySubarrays(int[] nums, int t) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i = 0 ; i < n ; i ++){
            pre[i+1] = pre[i] + (nums[i] == t ? 1 : 0);
        }
int ans = 0;
        for(int i = 0 ; i < n;  i++){
            for(int j = i ; j < n ; j++){
                int count = pre[j+1] - pre[i];
                int size = j - i + 1;
                if(size/2 < count) ans++;
            }
        }
        return ans;
    }
    
}