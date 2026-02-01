// Last updated: 2/1/2026, 10:56:48 PM
1// Time Complex.- for O(n) for traversal O(n) sorting O(nlog n) for array itteration O(n)*O(log n) for binary search
2// 							overall = O(n*log n)
3
4
5
6class Solution 
7{
8    //Asked in Uber
9	
10    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) 
11    {
12        int[] tmp=nums1.clone();
13        long totalDiff=0;
14        for(int i=0;i<nums1.length;i++)
15            totalDiff+=Math.abs(nums1[i]-nums2[i]);
16        
17        int index,k;
18        long result =totalDiff;
19        Arrays.sort(tmp);
20        for(int i=0;i<nums1.length;i++)
21        {
22            index=BinarySearch(tmp,nums2[i]);
23            int leftIndx=(index==0)? index:index-1;
24            int rightIndx=(index==tmp.length)? index-1:index;
25            
26            int diff= Math.min(Math.abs(nums2[i]-tmp[leftIndx]),Math.abs(nums2[i]-tmp[rightIndx]));
27            
28            result=Math.min(result,totalDiff-Math.abs(nums1[i]-nums2[i])+diff);
29        }
30        return (int)(result % 1000000007); // put result % 1000000007 in breacket 
31    }
32    
33    int BinarySearch(int[] tmp,int k)
34    {
35        int left=0,right=tmp.length-1;
36        int mid;
37        while(left<right)
38        {
39            mid=left+(right-left)/2;
40            if(tmp[mid]==k)
41                return mid;
42            if(tmp[mid]>k)
43                right=mid;
44            else
45                left=mid+1;
46        }
47        return left;
48    }
49}