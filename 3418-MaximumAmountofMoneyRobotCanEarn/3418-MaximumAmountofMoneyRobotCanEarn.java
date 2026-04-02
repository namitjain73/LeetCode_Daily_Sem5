// Last updated: 4/2/2026, 8:38:45 PM
1import java.util.*;
2
3class Solution {
4    public int maximumAmount(int[][] coins) {
5        int n = coins.length;
6        int m = coins[0].length;
7
8        int[][][] dp = new int[n][m][3];
9        for(int[][] dpp : dp)
10            for(int[] d : dpp)
11                Arrays.fill(d, Integer.MIN_VALUE);
12
13        return solver(coins, 0, 0, 2, dp);
14    }
15
16    public int solver(int[][] arr, int i, int j, int skip, int[][][] dp){
17        if(i >= arr.length || j >= arr[0].length)
18            return Integer.MIN_VALUE;
19
20        if(i == arr.length-1 && j == arr[0].length-1){
21            if(arr[i][j] < 0 && skip > 0) return 0;
22            return arr[i][j];
23        }
24
25        if(dp[i][j][skip] != Integer.MIN_VALUE)
26            return dp[i][j][skip];
27
28        int ans;
29
30        if(arr[i][j] < 0 && skip > 0){
31            int x = Math.max(
32                solver(arr, i+1, j, skip-1, dp),
33                solver(arr, i, j+1, skip-1, dp)
34            );
35
36            int y = Math.max(
37                solver(arr, i+1, j, skip, dp),
38                solver(arr, i, j+1, skip, dp)
39            );
40
41            if(y != Integer.MIN_VALUE) y += arr[i][j];
42
43            ans = Math.max(x, y);
44        } else {
45            int next = Math.max(
46                solver(arr, i+1, j, skip, dp),
47                solver(arr, i, j+1, skip, dp)
48            );
49
50            if(next == Integer.MIN_VALUE) return dp[i][j][skip] = Integer.MIN_VALUE;
51
52            ans = next + arr[i][j];
53        }
54
55        return dp[i][j][skip] = ans;
56    }
57}