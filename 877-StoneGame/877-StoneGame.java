// Last updated: 8/3/2026, 1:27:40 AM
1class Solution {
2    public boolean stoneGame(int[] piles) {
3       Integer[][]arr=new Integer[piles.length][piles.length];
4        return helper(piles,0,piles.length-1,arr)>=0;
5    }
6    public static int helper(int[]arr,int start,int end,Integer[][]dp){
7        if(start==end)return arr[start];
8        if(dp[start][end]!=null)return dp[start][end];
9        int takeStart=arr[start]-helper(arr,start+1,end,dp);
10        int takeEnd=arr[end]-helper(arr,start,end-1,dp);
11        return dp[start][end]=Math.max(takeStart,takeEnd);
12    }
13}