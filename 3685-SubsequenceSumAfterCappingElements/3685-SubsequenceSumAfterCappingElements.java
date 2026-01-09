// Last updated: 1/9/2026, 11:41:55 PM
1import java.util.Arrays;
2class Solution {
3    static boolean[] dp = new boolean[4001];
4    public static boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
5        Arrays.sort(nums);
6        int n = nums.length;
7        Arrays.fill(dp, false);
8        dp[0] = true;
9        int p = 0;
10        boolean[] ans = new boolean[n];
11        for (int x = 1; x <= n; x++) {
12            while (p < n && nums[p]< x){
13                for (int j = k; j >= nums[p]; j--) dp[j] |= dp[j-nums[p]];
14                p++;
15            }
16            int cnt = n-p;
17            for (int j = 0; j <= cnt; j++) {
18                int weight = x *j;
19                if(k < weight)break;
20                if(dp[k-weight]){
21                    ans[x -1] = true;
22                    break;
23                }
24            }
25        }
26
27        return ans;
28    }
29
30}