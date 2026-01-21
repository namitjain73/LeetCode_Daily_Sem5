// Last updated: 1/21/2026, 11:42:05 AM
1class Solution {
2    public int xorAllNums(int[] nums1, int[] nums2) {
3        int ans = 0;
4        if(nums2.length % 2 != 0) for(int i = 0 ; i < nums1.length ; i++) ans ^= nums1[i];
5        if(nums1.length % 2 != 0) for(int i = 0 ; i < nums2.length ; i++) ans ^= nums2[i]; 
6        return ans;
7    }
8}