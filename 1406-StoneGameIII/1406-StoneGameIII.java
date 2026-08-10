// Last updated: 8/10/2026, 10:22:19 AM
1class Solution {
2    public String stoneGameIII(int[] piles) {
3        int n = piles.length;
4        int[] dp = new int[n];
5        Arrays.fill(dp , -1);
6        int sum = 0;
7        for(int i : piles) sum += i;
8        int ans = solver(piles , 0 , dp);
9        System.out.println(ans);
10        return ans > 0 ? "Alice" : ans == 0 ? "Tie" : "Bob";
11    }
12    public int solver(int[] arr , int i, int[] dp ){
13        if(i >= arr.length) return 0;
14        if(dp[i] != -1) return dp[i];
15
16        
17        int ans = arr[i] - solver(arr , i+1 , dp );
18        if(i+1 < arr.length) ans = Math.max( arr[i] + arr[i+1] - solver(arr , i+2 , dp ),ans);
19        if(i+2 < arr.length) ans = Math.max( arr[i] + arr[i+1] + arr[i+2] - solver(arr , i+3 , dp ),ans);
20        
21        return dp[i] = ans;
22    }
23}