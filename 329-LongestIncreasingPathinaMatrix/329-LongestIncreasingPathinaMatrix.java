// Last updated: 8/24/2026, 8:01:17 PM
1class Solution {
2    public int longestIncreasingPath(int[][] matrix) {
3        int res = 0;
4        int[][] dp = new int[matrix.length][matrix[0].length];
5        for(int i[] : dp) Arrays.fill(i , -1);
6        for(int i = 0 ; i < matrix.length ; i++){
7            for(int j= 0 ;  j < matrix[0].length ; j++){
8                res = Math.max(res,solver(matrix , i , j , -1 ,dp));
9            }
10        }
11        return res;
12    }
13    public int solver(int[][] arr , int i , int j , int pre , int[][] dp){
14        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] <= pre) return 0;
15        if(dp[i][j] != -1) return dp[i][j];
16
17        int[] a = {1,-1,0,0};
18        int[] b = {0,0,1,-1};
19        int res= 0;
20        for(int k = 0 ; k < 4 ; k++){
21            int ni = i + a[k];
22            int nj = j + b[k];
23            res = Math.max(res , solver(arr , ni , nj , arr[i][j] , dp )+1);
24        }
25        return dp[i][j] = res;
26    }
27}