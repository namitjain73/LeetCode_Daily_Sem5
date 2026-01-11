// Last updated: 1/11/2026, 7:36:24 PM
1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int []diff=new int[100001];
4        
5        long k=k1+k2;
6        int maxDiff=0;
7        long totalDiff=0;
8        
9        for(int i=0;i<nums1.length;i++){
10            int currDiff=Math.abs(nums1[i]-nums2[i]);
11            
12            if(currDiff>0){
13                totalDiff+=currDiff;
14                diff[currDiff]++;
15                maxDiff=Math.max(maxDiff, currDiff);
16            }
17            
18        }
19        
20        if(totalDiff<=k){
21            return 0;
22        }
23        
24        for(int i=maxDiff;i>0 && k>0;i--){
25            
26            if(diff[i]>0){
27                if(diff[i]>=k){
28                    diff[i]-=k;
29                    diff[i-1]+=k;
30                    k=0;
31                }else{
32                    diff[i-1]+=diff[i];
33                    k-=diff[i];
34                    diff[i]=0;
35                }
36            } 
37        }
38        
39        long res=0;
40        
41        for(int i=0;i<=maxDiff;i++){
42            if(diff[i]>0){
43                res+=(long)Math.pow((long)i,2)*diff[i];
44            }
45        }
46        
47        return res;
48    }
49}