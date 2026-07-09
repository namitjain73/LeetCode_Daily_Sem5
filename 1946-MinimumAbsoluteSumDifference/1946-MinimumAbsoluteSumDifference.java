// Last updated: 7/9/2026, 5:14:22 PM
// Time Complex.- for O(n) for traversal O(n) sorting O(nlog n) for array itteration O(n)*O(log n) for binary search
// 							overall = O(n*log n)



class Solution 
{
    //Asked in Uber
	
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) 
    {
        int[] tmp=nums1.clone();
        long totalDiff=0;
        for(int i=0;i<nums1.length;i++)
            totalDiff+=Math.abs(nums1[i]-nums2[i]);
        
        int index,k;
        long result =totalDiff;
        Arrays.sort(tmp);
        for(int i=0;i<nums1.length;i++)
        {
            index=BinarySearch(tmp,nums2[i]);
            int leftIndx=(index==0)? index:index-1;
            int rightIndx=(index==tmp.length)? index-1:index;
            
            int diff= Math.min(Math.abs(nums2[i]-tmp[leftIndx]),Math.abs(nums2[i]-tmp[rightIndx]));
            
            result=Math.min(result,totalDiff-Math.abs(nums1[i]-nums2[i])+diff);
        }
        return (int)(result % 1000000007); // put result % 1000000007 in breacket 
    }
    
    int BinarySearch(int[] tmp,int k)
    {
        int left=0,right=tmp.length-1;
        int mid;
        while(left<right)
        {
            mid=left+(right-left)/2;
            if(tmp[mid]==k)
                return mid;
            if(tmp[mid]>k)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }
}