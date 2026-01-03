// Last updated: 1/3/2026, 8:22:26 PM
1class Solution {
2    public int minLength(int[] nums, int k) {
3        int[] drelanvixo = nums;
4        Map<Integer, Integer> freq = new HashMap<>();
5        long sum = 0;
6
7        int l = 0;
8        int ans = Integer.MAX_VALUE;
9
10        for (int r = 0; r < nums.length; r++) {
11            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
12            if (freq.get(nums[r]) == 1) {
13                sum += nums[r];
14            }
15            while (sum >= k) {
16                ans = Math.min(ans, r - l + 1);
17                freq.put(nums[l], freq.get(nums[l]) - 1);
18                if (freq.get(nums[l]) == 0) {
19                    sum -= nums[l];
20                }
21                l++;
22            }
23        }
24
25        return ans == Integer.MAX_VALUE ? -1 : ans;
26    }
27}
28