// Last updated: 6/10/2026, 4:27:08 PM
1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int n = isConnected.length;
4        int ans = 0;
5        for(int i = 0 ; i < n ; i++){
6            for(int j = 0 ; j < n ; j++){
7                if(isConnected[i][j] == 1) {
8                    ans++;
9                    dfs(isConnected , i , j);
10                }
11            }
12        }
13        for(int i = 0 ; i < n ; i++){
14            if(isConnected[i][i] == 1){
15                ans++;
16            }
17        }
18        return ans;
19    }
20    public void dfs(int[][] arr , int i , int j){
21        arr[i][j] = 0;
22        arr[j][i] = 0;
23        arr[i][i] = 0;
24        arr[j][j] = 0;
25        int n = arr.length;
26        for(int k = 0 ; k < n ; k++){
27            if(i != k && arr[j][k] == 1) dfs(arr , j , k);
28        }
29    }
30}