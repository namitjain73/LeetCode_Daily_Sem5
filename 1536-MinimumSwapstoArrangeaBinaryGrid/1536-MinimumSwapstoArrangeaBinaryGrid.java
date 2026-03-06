// Last updated: 3/6/2026, 9:21:46 PM
1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] zeros = new int[n];
5        for (int i = 0; i < n; i++) {
6            int count = 0;
7            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
8                count++;
9            }
10            zeros[i] = count;
11        }
12
13        int swaps = 0;
14
15        for (int i = 0; i < n; i++) {
16            int needed = n - i - 1;
17            int j = i;
18            while (j < n && zeros[j] < needed) j++;
19
20            if (j == n) return -1;
21            while (j > i) {
22                int temp = zeros[j];
23                zeros[j] = zeros[j - 1];
24                zeros[j - 1] = temp;
25                j--;
26                swaps++;
27            }
28        }
29
30        return swaps;
31    }
32}