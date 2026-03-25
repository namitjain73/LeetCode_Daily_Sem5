// Last updated: 3/25/2026, 10:41:22 AM
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        long sum = 0;
4        int n = grid.length;
5        int m = grid[0].length;
6        for(int i = 0 ; i <n  ; i++){
7            for(int j = 0 ; j < m ;  j++){
8                sum += grid[i][j];
9            }
10        }
11        if(sum % 2 == 1) return false;
12
13        sum = sum / 2;
14        long sum1 = 0;
15        for(int i = 0 ; i < n ; i++){
16            for(int j = 0 ; j < m ; j++){
17                sum1 += grid[i][j];
18            }
19            if(sum == sum1) return true;
20        }
21
22        sum1 = 0;
23        for(int i = 0 ; i < m ; i++){
24            for(int j = 0 ; j < n ; j++){
25                sum1 += grid[j][i];
26            }
27            if(sum == sum1) return true;
28        }
29
30
31        return false;
32    }
33}