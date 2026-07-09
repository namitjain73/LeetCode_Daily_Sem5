// Last updated: 7/9/2026, 5:02:09 PM
class Solution {
    public int maxFrequency(int[] nums, int k) {
       
        int[][] frq = new int[50][];
        int cntK = 0, max = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k){cntK++;continue;}
            int[] curr = frq[nums[i] - 1];
            if(curr == null || curr[0] == -100 || (curr != null && (curr[0] - (cntK - curr[1]) <= 0))) {
                frq[nums[i] - 1] = new int[]{1, cntK, 1};

            }else{
                curr[0]++;curr[2] = curr[0] - (cntK - curr[1]);
                if( curr[2] > max ){
                    max = curr[2];
                }
                
                if(curr[2] <= 0){curr[0] = -100;}
            }
       }
       return (max + cntK > nums.length) ? nums.length : max + cntK;
    }
}