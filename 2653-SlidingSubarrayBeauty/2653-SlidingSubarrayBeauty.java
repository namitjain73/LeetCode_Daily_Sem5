// Last updated: 2/5/2026, 11:42:18 PM
1class Solution {
2    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
3    int[] counter = new int[50], ans = new int[nums.length - k + 1];;
4    for (int i = 0; i < nums.length; i++) {
5        if (nums[i] < 0) counter[nums[i] + 50]++;
6        if (i - k >= 0 && nums[i - k] < 0) counter[nums[i - k] + 50]--;
7        if (i - k + 1 < 0) continue;
8        for (int j = 0, count = 0; j < 50; j++) {
9            count += counter[j];
10            if (count >= x) {
11                ans[i - k + 1] = j - 50;
12                break;
13            }
14        }
15    }
16    return ans;
17}
18}