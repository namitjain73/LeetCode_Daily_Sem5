// Last updated: 7/9/2026, 5:14:33 PM
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum==goal){
            return 0;
        }
        long diff=Math.abs(goal-sum);
        if(diff%limit==0){
            return (int)(diff/(long)limit);
        }
        else{
            return (int)((diff/(long)limit)+1);
        }
    }
}