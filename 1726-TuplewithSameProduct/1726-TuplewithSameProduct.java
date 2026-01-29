// Last updated: 1/29/2026, 10:11:26 PM
1class Solution {
2    public int tupleSameProduct(int[] nums) {
3        Map<Integer, Integer> products = new HashMap<>();
4        int ans = 0, n = nums.length;
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                int prod = nums[i] * nums[j];
8                ans += products.getOrDefault(prod, 0);
9                products.put(prod, products.getOrDefault(prod, 0) + 1);
10            }
11        }
12        return ans * 8;
13    }
14}