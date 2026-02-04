// Last updated: 2/5/2026, 2:53:42 AM
1class Solution {
2    long NEG = -100000000000000L;
3    Long[][] dp;
4
5    long f(int index, int status, int n, int[] nums) {
6        if (index == n) {
7            return status == 3 ? 0 : NEG;
8        }
9
10        if (dp[index][status] != null) return dp[index][status];
11
12        long take = NEG;
13        long notTake = NEG;
14
15        if (status == 0) {
16            notTake = f(index + 1, 0, n, nums);
17        }
18
19        if (status == 3) {
20            take = nums[index];
21        }
22
23        if (index + 1 < n) {
24            if (status == 0 && nums[index + 1] > nums[index]) {
25                take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
26            } 
27            else if (status == 1) {
28                if (nums[index + 1] > nums[index]) {
29                    take = Math.max(take, nums[index] + f(index + 1, 1, n, nums));
30                } else if (nums[index + 1] < nums[index]) {
31                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
32                }
33            } 
34            else if (status == 2) {
35                if (nums[index + 1] < nums[index]) {
36                    take = Math.max(take, nums[index] + f(index + 1, 2, n, nums));
37                } else if (nums[index + 1] > nums[index]) {
38                    take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
39                }
40            } 
41            else if (status == 3 && nums[index + 1] > nums[index]) {
42                take = Math.max(take, nums[index] + f(index + 1, 3, n, nums));
43            }
44        }
45
46        return dp[index][status] = Math.max(take, notTake);
47    }
48
49    public long maxSumTrionic(int[] nums) {
50        int n = nums.length;
51        dp = new Long[n][4];
52        return f(0, 0, n, nums);
53    }
54}