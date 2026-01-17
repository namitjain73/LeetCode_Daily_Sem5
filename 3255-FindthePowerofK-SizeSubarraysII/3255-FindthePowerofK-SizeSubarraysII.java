// Last updated: 1/17/2026, 10:12:23 PM
1class Solution {
2    public int[] resultsArray(int[] nums, int k) {
3        int n = nums.length;
4        int[] ans = new int[n - k + 1];
5        int c = 0;
6        for(int i = 1 ; i < k ; i++){
7            if(nums[i] == nums[i-1]+1){
8                c++;
9            }
10        }
11        ans[0] = (c == k-1) ? nums[k-1] : -1;
12        for(int i = k ; i < n ; i++){
13            if(nums[i-k+1] == nums[i-k]+1){
14                c--;
15            }
16
17            if(nums[i] == nums[i-1]+1){
18                c++;
19            }
20
21            ans[i-k+1] = (c == k-1) ? nums[i] : -1;
22        }
23        return ans;
24    }
25}