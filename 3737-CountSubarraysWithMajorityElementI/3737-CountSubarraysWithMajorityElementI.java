// Last updated: 6/26/2026, 12:57:12 AM
1class Solution {
2    public int countMajoritySubarrays(int[] nums, int t) {
3        int n = nums.length;
4        int[] pre = new int[n+1];
5        for(int i = 0 ; i < n ; i ++){
6            pre[i+1] = pre[i] + (nums[i] == t ? 1 : 0);
7        }
8int ans = 0;
9        for(int i = 0 ; i < n;  i++){
10            for(int j = i ; j < n ; j++){
11                int count = pre[j+1] - pre[i];
12                int size = j - i + 1;
13                if(size/2 < count) ans++;
14            }
15        }
16        return ans;
17    }
18    
19}