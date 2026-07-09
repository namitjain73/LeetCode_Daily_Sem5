// Last updated: 7/9/2026, 5:09:28 PM
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if(nums2.length % 2 != 0) for(int i = 0 ; i < nums1.length ; i++) ans ^= nums1[i];
        if(nums1.length % 2 != 0) for(int i = 0 ; i < nums2.length ; i++) ans ^= nums2[i]; 
        return ans;
    }
}