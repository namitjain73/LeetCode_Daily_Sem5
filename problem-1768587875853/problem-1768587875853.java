// Last updated: 1/16/2026, 11:54:35 PM
1class Solution {
2    public int minElements(int[] nums, int limit, int goal) {
3        long sum=0;
4        for(int i=0;i<nums.length;i++){
5            sum+=nums[i];
6        }
7        if(sum==goal){
8            return 0;
9        }
10        long diff=Math.abs(goal-sum);
11        if(diff%limit==0){
12            return (int)(diff/(long)limit);
13        }
14        else{
15            return (int)((diff/(long)limit)+1);
16        }
17    }
18}