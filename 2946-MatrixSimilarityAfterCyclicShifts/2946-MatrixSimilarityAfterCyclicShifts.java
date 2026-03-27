// Last updated: 3/27/2026, 6:53:42 PM
1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int n = mat.length;
4        int m = mat[0].length;
5        int[][] arr = new int[n][m];
6        k = k % m;
7
8        // if(k != 0){
9            for(int i = 0 ; i < n ; i++){
10                if(i % 2 == 0){
11                    pos(mat[i] , k , arr[i]);
12                }else{
13                    neg(mat[i] , k , arr[i]);
14                }
15            }
16        // }
17        for(int i = 0 ; i < n ; i++){
18            for(int j = 0 ; j < m ; j++){
19                if(mat[i][j] != arr[i][j]) return false;
20             }
21        }
22        return true;
23    }
24
25    public void neg(int[] mat , int k , int[] arr){
26        int n = mat.length;
27        for(int i  = 0 ;i < n ; i++){
28            arr[(i+k)%n] = mat[i];
29        }
30    }
31
32    public void pos(int[] mat , int k , int[] arr){
33        int n = mat.length;
34        for(int i  = 0 ;i < n ; i++){
35            arr[i] = mat[(i+k)%n];
36        }
37    }
38}