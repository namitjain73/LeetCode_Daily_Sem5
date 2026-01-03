// Last updated: 1/3/2026, 3:39:04 PM
1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        int len = 1;
6        dp[0] = nums[0];
7
8        for(int i = 1; i < n ; i++){
9            if(dp[len-1] < nums[i]){
10                dp[len] = nums[i];
11                len++;
12            }else{
13                int idx = bs(dp,nums[i],len-1);
14                dp[idx] = nums[i];
15            }
16        }
17        return len;
18    }
19    public int bs(int[] dp , int t,int hi){
20        int lo =0;
21        // int hi = dp.length -1 ;
22        int ans = 0;
23        while(lo <= hi){
24            int mid = lo + (hi - lo)/2;
25            if(dp[mid] >= t){
26                ans = mid;
27                hi = mid - 1;
28            }else{
29                lo = mid + 1;
30            }
31        }
32        return ans;
33    }
34}