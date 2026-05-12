// Last updated: 5/12/2026, 4:14:58 PM
1class Solution {
2    public int minimumEffort(int[][] tasks) {
3        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
4
5        int curr = 0;
6        int ans  = 0;
7        for (int[] task : tasks) {
8            int actual  = task[0];
9            int minimum = task[1];
10            if (curr < minimum) {
11                ans  += (minimum - curr);
12                curr  = minimum;
13            }
14            curr -= actual;
15        }
16        return ans;
17    }
18}