// Last updated: 1/20/2026, 1:38:00 AM
1class Solution {
2    public int numTeams(int[] arr) {
3        int ans = 0;
4
5        int n = arr.length;
6        for(int i = 0 ; i < n ; i++){
7            for(int j = i+1;  j < n ; j++){
8                for(int k = j+1 ; k < n ; k++){
9                    if((arr[i] < arr[j] && arr[j] < arr[k]) || (arr[i] > arr[j]&& arr[j] >arr[k])) ans++;
10                }
11            }
12        }
13        return ans;
14    }
15}