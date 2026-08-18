// Last updated: 8/19/2026, 12:04:59 AM
1class Solution {
2    public int largestInteger(int[] nums, int k) {
3        int n = nums.length;
4
5        int[] freq = new int[51];
6
7        for (int x : nums) {
8            freq[x]++;
9        }
10
11        if (k == 1) {
12            for (int x = 50; x >= 0; x--) {
13                if (freq[x] == 1) {
14                    return x;
15                }
16            }
17
18            return -1;
19        }
20
21        if (k == n) {
22            int answer = 0;
23
24            for (int x : nums) {
25                answer = Math.max(answer, x);
26            }
27
28            return answer;
29        }
30
31        int answer = -1;
32
33        if (freq[nums[0]] == 1) {
34            answer = Math.max(answer, nums[0]);
35        }
36
37        if (freq[nums[n - 1]] == 1) {
38            answer = Math.max(answer, nums[n - 1]);
39        }
40
41        return answer;
42    }
43}