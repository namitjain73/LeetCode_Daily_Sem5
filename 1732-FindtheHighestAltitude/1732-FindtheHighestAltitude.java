// Last updated: 6/19/2026, 11:14:40 AM
1class Solution {
2    public int largestAltitude(int[] gain) {
3        
4        int n = gain.length;
5        int[] arr = new int[n+1];
6        arr[0]  = 0;
7        int max = 0;
8        for(int i = 1 ; i <= n ; i++){
9            arr[i] = gain[i-1] + arr[i-1];
10            max = Math.max(max , arr[i]);
11        }
12        return max;
13    }
14}