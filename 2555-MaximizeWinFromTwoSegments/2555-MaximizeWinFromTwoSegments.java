// Last updated: 1/22/2026, 11:29:19 PM
1class Solution {
2    public int maximizeWin(int[] arr, int k) {
3        int n = arr.length;
4        int[] left = new int[n];
5        int[] right = new int[n];
6        left[0] = 1;
7        for(int i = 1,j=0 ; i < n ; i++){
8            if(arr[i] - arr[j] > k) j++;
9            left[i] = Math.max(left[i-1], i-j+1);
10        }
11        right[n-1] = 1;
12        for(int i = n-2,j=n-1 ; i >= 0 ; i--){
13            if(arr[j]-arr[i] > k) j--;
14            right[i]= Math.max(right[i+1],j-i+1);
15        }
16
17        int ans = 0;
18        for(int i = 0; i <= n ; i++){
19            ans = Math.max(ans , ((i==0)?0:left[i-1])+((i==n)?0:right[i]));
20        }
21        return ans;
22
23    }
24}