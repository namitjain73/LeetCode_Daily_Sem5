// Last updated: 5/14/2026, 12:30:42 AM
1class Solution {
2
3    public int minMoves(int[] nums, int limit) {
4
5        int n = nums.length;
6
7        // difference array
8        int[] diff = new int[2 * limit + 2];
9
10        for (int i = 0; i < n / 2; i++) {
11
12            int a = nums[i];
13            int b = nums[n - 1 - i];
14
15            int low = Math.min(a, b) + 1;
16            int high = Math.max(a, b) + limit;
17
18            int sum = a + b;
19
20            // initially all sums need 2 moves
21            diff[2] += 2;
22            diff[2 * limit + 1] -= 2;
23
24            // one move range
25            diff[low] -= 1;
26            diff[high + 1] += 1;
27
28            // exact sum needs 0 move
29            diff[sum] -= 1;
30            diff[sum + 1] += 1;
31        }
32
33        int ans = Integer.MAX_VALUE;
34        int moves = 0;
35
36        // calculate prefix sum
37        for (int target = 2; target <= 2 * limit; target++) {
38            moves += diff[target];
39            ans = Math.min(ans, moves);
40        }
41
42        return ans;
43    }
44}