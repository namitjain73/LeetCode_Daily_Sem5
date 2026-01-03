// Last updated: 1/3/2026, 11:56:59 AM
1class Solution {
2    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
3        int n = profit.length;
4
5        int[][] arr = new int[n][3];
6        for(int i = 0 ; i < n ; i++){
7            arr[i][0] = startTime[i];
8            arr[i][1] = endTime[i];
9            arr[i][2] = profit[i];
10        }
11
12        Arrays.sort(arr , (a,b)->a[0] - b[0]);
13        int[] dp = new int[n+1];
14        Arrays.fill(dp,-1);
15
16        return solver(arr , 0 , dp , n);
17    }
18    public int solver(int[][] arr , int idx, int[] dp , int n){
19        if(idx == n){
20            return 0;
21        }
22
23        if(dp[idx] != -1) return dp[idx];
24
25        int skip = solver(arr , idx+1 , dp , n);
26        int take = solver(arr,findNext(arr[idx][1],arr,n),dp,n)+arr[idx][2];
27        return dp[idx] = Math.max(skip,take);
28    }
29    public int findNext(int node , int[][] arr , int n){
30        int lo = 0;
31        int hi = n-1;
32        int ans = n;
33
34        while(lo <= hi){
35            int mid = lo + (hi - lo)/2;
36
37            if(arr[mid][0] >= node){
38                ans = mid;
39                hi= mid - 1;
40            }else lo = mid + 1;
41        }
42        return ans;
43    }
44}