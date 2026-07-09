// Last updated: 7/9/2026, 5:10:22 PM
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int []diff=new int[100001];
        
        long k=k1+k2;
        int maxDiff=0;
        long totalDiff=0;
        
        for(int i=0;i<nums1.length;i++){
            int currDiff=Math.abs(nums1[i]-nums2[i]);
            
            if(currDiff>0){
                totalDiff+=currDiff;
                diff[currDiff]++;
                maxDiff=Math.max(maxDiff, currDiff);
            }
            
        }
        
        if(totalDiff<=k){
            return 0;
        }
        
        for(int i=maxDiff;i>0 && k>0;i--){
            
            if(diff[i]>0){
                if(diff[i]>=k){
                    diff[i]-=k;
                    diff[i-1]+=k;
                    k=0;
                }else{
                    diff[i-1]+=diff[i];
                    k-=diff[i];
                    diff[i]=0;
                }
            } 
        }
        
        long res=0;
        
        for(int i=0;i<=maxDiff;i++){
            if(diff[i]>0){
                res+=(long)Math.pow((long)i,2)*diff[i];
            }
        }
        
        return res;
    }
}