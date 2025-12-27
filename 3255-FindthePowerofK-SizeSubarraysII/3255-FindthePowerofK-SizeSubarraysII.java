// Last updated: 12/28/2025, 1:22:39 AM
1class Solution {
2    public int[] resultsArray(int[] nums, int k) {
3        int n = nums.length;
4        int[] ans = new int[n - k + 1];
5        int c = 0;
6
7        for(int i = 1 ; i < k ; i++){
8            if(nums[i] == nums[i-1]+1){
9                c++;
10            }
11        }
12
13        ans[0] = (c == k-1) ? nums[k-1] : -1;
14
15        for(int i = k ; i < n ; i++){
16            if(nums[i-k+1] == nums[i-k]+1){
17                c--;
18            }
19
20            if(nums[i] == nums[i-1]+1){
21                c++;
22            }
23
24            ans[i-k+1] = (c == k-1) ? nums[i] : -1;
25        }
26        return ans;
27    }
28}