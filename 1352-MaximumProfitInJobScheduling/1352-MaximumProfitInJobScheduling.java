// Last updated: 7/9/2026, 5:17:20 PM
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;

        int[][] arr = new int[n][3];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr , (a,b)->a[0] - b[0]);
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return solver(arr , 0 , dp , n);
    }
    public int solver(int[][] arr , int idx, int[] dp , int n){
        if(idx == n){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int skip = solver(arr , idx+1 , dp , n);
        int take = solver(arr,findNext(arr[idx][1],arr,n),dp,n)+arr[idx][2];
        return dp[idx] = Math.max(skip,take);
    }
    public int findNext(int node , int[][] arr , int n){
        int lo = 0;
        int hi = n-1;
        int ans = n;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(arr[mid][0] >= node){
                ans = mid;
                hi= mid - 1;
            }else lo = mid + 1;
        }
        return ans;
    }
}