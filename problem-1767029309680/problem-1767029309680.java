// Last updated: 12/29/2025, 10:58:29 PM
1class Solution {
2    int sum;
3    public int subsetXORSum(int[] nums) {
4        sum = 0;
5        findSubsets(nums , 0 , 0);
6        return sum;
7    }
8     public void findSubsets(int[] arr, int index, int ans) {
9        if (index == arr.length) {
10            sum += ans;
11            return;
12        }
13        findSubsets(arr, index + 1, ans);
14        findSubsets(arr, index + 1, arr[index]^ans);
15    }
16}