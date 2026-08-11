// Last updated: 8/11/2026, 12:16:33 PM
1class Solution {
2    public String stoneGameIII(int[] nums) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        Arrays.fill(dp , -1);
6        int x = solver(nums,  0 , dp);
7        System.out.println(x);
8        return x == 0 ? "Tie" : x > 0 ? "Alice" : "Bob";
9    }
10    public int solver(int[] arr, int i ,  int[] dp){
11        if(i >= arr.length) return 0;
12        if(dp[i] != -1) return dp[i];
13
14        int res = arr[i] - solver(arr , i+1 , dp);
15        if(i+1 < arr.length) res = Math.max(res , arr[i] + arr[i + 1] - solver(arr , i+2 , dp));
16        if(i+2 < arr.length) res = Math.max(res , arr[i] + arr[i+1] + arr[i+2] - solver(arr , i+3 , dp));
17        return dp[i] = res;
18    }
19}