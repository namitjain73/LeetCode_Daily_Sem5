// Last updated: 7/9/2026, 5:02:40 PM
import java.util.*;

class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int[][][] dp = new int[n][m][3];
        for(int[][] dpp : dp)
            for(int[] d : dpp)
                Arrays.fill(d, Integer.MIN_VALUE);

        return solver(coins, 0, 0, 2, dp);
    }

    public int solver(int[][] arr, int i, int j, int skip, int[][][] dp){
        if(i >= arr.length || j >= arr[0].length)
            return Integer.MIN_VALUE;

        if(i == arr.length-1 && j == arr[0].length-1){
            if(arr[i][j] < 0 && skip > 0) return 0;
            return arr[i][j];
        }

        if(dp[i][j][skip] != Integer.MIN_VALUE)
            return dp[i][j][skip];

        int ans;

        if(arr[i][j] < 0 && skip > 0){
            int x = Math.max(
                solver(arr, i+1, j, skip-1, dp),
                solver(arr, i, j+1, skip-1, dp)
            );

            int y = Math.max(
                solver(arr, i+1, j, skip, dp),
                solver(arr, i, j+1, skip, dp)
            );

            if(y != Integer.MIN_VALUE) y += arr[i][j];

            ans = Math.max(x, y);
        } else {
            int next = Math.max(
                solver(arr, i+1, j, skip, dp),
                solver(arr, i, j+1, skip, dp)
            );

            if(next == Integer.MIN_VALUE) return dp[i][j][skip] = Integer.MIN_VALUE;

            ans = next + arr[i][j];
        }

        return dp[i][j][skip] = ans;
    }
}