// Last updated: 7/9/2026, 5:15:45 PM
class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int mod = 1_000_000_007;
        int i = 0 , j=0 , n = nums1.length , m=nums2.length;
        long sum1 = 0 , sum2=0 , ans=0;

        while(i<n && j < m){
            if(nums1[i] == nums2[j]){
                sum1 += nums1[i];
                sum2 += nums2[j];
                ans += Math.max(sum1 , sum2);
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }else if(nums1[i] > nums2[j]){
                sum2 += nums2[j];
                j++;
            }else{
                sum1 += nums1[i];
                i++;
            }
        }

        while(i < n){
            sum1 += nums1[i];
            i++;
        }
        while(j < m){
            sum2 += nums2[j];
            j++;
        }
        ans += Math.max(sum1 , sum2);
        return (int)(ans%mod);
    }
}