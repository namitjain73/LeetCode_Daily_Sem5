// Last updated: 7/9/2026, 5:00:37 PM
import java.util.Arrays;
class Solution {
    static boolean[] dp = new boolean[4001];
    public static boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        Arrays.fill(dp, false);
        dp[0] = true;
        int p = 0;
        boolean[] ans = new boolean[n];
        for (int x = 1; x <= n; x++) {
            while (p < n && nums[p]< x){
                for (int j = k; j >= nums[p]; j--) dp[j] |= dp[j-nums[p]];
                p++;
            }
            int cnt = n-p;
            for (int j = 0; j <= cnt; j++) {
                int weight = x *j;
                if(k < weight)break;
                if(dp[k-weight]){
                    ans[x -1] = true;
                    break;
                }
            }
        }

        return ans;
    }

}