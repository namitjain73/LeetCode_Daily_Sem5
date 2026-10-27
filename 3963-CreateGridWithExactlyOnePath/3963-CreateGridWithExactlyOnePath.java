// Last updated: 10/27/2026, 2:55:06 PM
1class Solution {
2    public String[] createGrid(int n, int m) {
3        char[][] arr = new char[n][m];
4        String[] s = new String[n];
5        for(char[] d : arr)Arrays.fill(d, '#');
6        solver(arr , 0 , 0);
7        for(int i = 0 ; i < n ; i++){
8            StringBuilder sb = new StringBuilder();
9            for(int j = 0 ; j < m ; j++){
10                sb.append(arr[i][j]);
11            }
12            s[i] = sb.toString();            
13        }
14        return s;
15    }
16    public boolean solver(char[][] arr , int i , int j){
17        if(i >= arr.length || j >= arr[0].length) return false;
18        if(i == arr.length-1 && j == arr[0].length -1){
19            arr[i][j] = '.';
20            return true;
21        }
22
23        arr[i][j] = '.';
24        if(solver(arr , i+1 , j)) return true;
25        if(solver(arr , i , j+1)) return true;
26        arr[i][j] = '#';
27        return false;
28
29    }
30}