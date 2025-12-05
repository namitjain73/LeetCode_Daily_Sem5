// Last updated: 12/5/2025, 11:07:05 PM
1class Solution {
2    public int countPartitions(int[] nums) {
3        int sum = 0;
4        for(int i : nums){
5            sum += i;
6        }
7
8        int res = 0;
9        int ans = 0;
10        for(int i = 0 ; i < nums.length-1 ;i++){
11            ans += nums[i];
12            sum -= nums[i];
13            if(Math.abs(ans-sum)%2 == 0) res++;
14        }
15        return res;
16    }
17}