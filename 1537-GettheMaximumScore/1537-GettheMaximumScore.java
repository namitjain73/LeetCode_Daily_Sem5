// Last updated: 4/3/2026, 10:47:52 AM
1class Solution {
2    public int maxSum(int[] nums1, int[] nums2) {
3        int mod = 1_000_000_007;
4        int i = 0 , j=0 , n = nums1.length , m=nums2.length;
5        long sum1 = 0 , sum2=0 , ans=0;
6
7        while(i<n && j < m){
8            if(nums1[i] == nums2[j]){
9                sum1 += nums1[i];
10                sum2 += nums2[j];
11                ans += Math.max(sum1 , sum2);
12                i++;
13                j++;
14                sum1 = 0;
15                sum2 = 0;
16            }else if(nums1[i] > nums2[j]){
17                sum2 += nums2[j];
18                j++;
19            }else{
20                sum1 += nums1[i];
21                i++;
22            }
23        }
24
25        while(i < n){
26            sum1 += nums1[i];
27            i++;
28        }
29        while(j < m){
30            sum2 += nums2[j];
31            j++;
32        }
33        ans += Math.max(sum1 , sum2);
34        return (int)(ans%mod);
35    }
36}