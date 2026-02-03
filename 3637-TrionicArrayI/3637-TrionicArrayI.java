// Last updated: 2/4/2026, 2:32:40 AM
1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int n = nums.length;
4        int peak = n - 1, valley = 0;
5
6        for (int i = 0; i < n - 1; i++) {
7            if (peak == n - 1 && nums[i] >= nums[i + 1])
8                peak = i;
9            if (valley == 0 && nums[n - 1 - i] <= nums[n - 2 - i])
10                valley = n - 1 - i;
11            if (peak < valley)
12                return isDecreasing(nums, peak, valley);
13        }
14
15        return false;
16    }
17
18    public boolean isDecreasing(int[] A, int a, int b) {
19        if (a == 0 || b == A.length - 1) return false;
20        for (int i = a; i < b; i++)
21            if (A[i] <= A[i + 1]) return false;
22        
23        return true;
24    }
25}
26