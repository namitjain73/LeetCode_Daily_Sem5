// Last updated: 3/24/2026, 10:32:41 PM
1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int size = n * m;
6        int mod = 12345;
7
8        int[] arr = new int[size];
9        int[] pre = new int[size];
10        int[] suf = new int[size];
11
12        int idx = 0;
13
14        for(int i = 0 ; i < m ; i++){
15            for(int j = 0 ; j < n ; j++){
16                arr[idx++] = grid[i][j];
17            }
18        }
19
20        suf[0] = 1;
21        for(int i = 1 ; i < size ; i++){
22            suf[i] = (int)(((long)suf[i-1] * arr[i-1]) % mod);
23        }
24
25        pre[size-1] = 1;
26        for(int i = size-2 ; i >= 0 ; i--){
27            pre[i] = (int)(((long)pre[i+1] * arr[i+1]) % mod);
28        }
29
30        idx = 0;
31        for(int i = 0 ; i < m ; i++){
32            for(int j = 0 ; j < n ; j++){
33                grid[i][j] = (int)(((long)pre[idx] * suf[idx]) % mod);
34                idx++;
35            }
36        }
37
38        return grid;
39    }
40}