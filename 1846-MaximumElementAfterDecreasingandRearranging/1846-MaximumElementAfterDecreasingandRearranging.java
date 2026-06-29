// Last updated: 6/29/2026, 12:16:52 PM
1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
3        Arrays.sort(arr);
4        int c = 1;
5        int max = 1;
6        int n = arr.length;
7        if(arr[0] != 1){
8            arr[0] = 1;
9        }
10        for(int i = 1 ; i < n ; i++){
11            if(arr[i] - arr[i-1] > 1) arr[i] = arr[i-1]+1;
12            max = Math.max(arr[i] , max);
13        }
14        return max;
15    }
16}