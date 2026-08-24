// Last updated: 8/24/2026, 10:36:30 PM
1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3        HashMap<Integer, Integer> m = new HashMap<>();
4
5        int i = 0, j = 0;
6        int res = 0;
7
8        while (j < nums.length) {
9            m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);
10
11            while (m.get(nums[j]) > k) {
12                m.put(nums[i], m.get(nums[i]) - 1);
13                i++;
14            }
15
16            res = Math.max(res, j - i + 1);
17            j++;
18        }
19
20        return res;
21    }
22}   