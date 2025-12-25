// Last updated: 12/26/2025, 3:30:50 AM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int i = 0;
4        int j = 0;
5        while(i < nums1.length && j < nums2.length){
6            if(nums1[i] == nums2[j]) return nums1[i];
7            if(nums1[i] < nums2[j])i++;
8            else j++;
9        }
10        return -1;
11    }
12}