// Last updated: 8/10/2026, 9:02:43 AM
1class Solution {
2    public boolean stoneGame(int[] piles) {
3        int n = piles.length;
4        int[][] dp = new int[n][n];
5        for(int[] d : dp) Arrays.fill(d , -1);
6        int sum = 0;
7        for(int i : piles) sum += i;
8        int ans = solver(piles , 0 , n-1, dp);
9        return ans > (sum / 2) ? true : false;
10    }
11    public int solver(int[] arr , int i, int j , int[][] dp){
12        if(i > j) return 0;
13        if(dp[i][j] != -1) return dp[i][j];
14
15        int left = arr[i] + Math.min(solver(arr , i+2 , j , dp) , solver(arr , i+1 , j-1 , dp));
16        int right = arr[j] + Math.min(solver(arr , i+1 , j-1, dp) , solver(arr , i , j-2 , dp));
17        dp[i][j] = Math.max(left , right);
18        return dp[i][j];
19
20    }
21}