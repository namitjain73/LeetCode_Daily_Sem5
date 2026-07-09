// Last updated: 7/9/2026, 5:25:29 PM
class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int currpost = 0;
        int calculate=  0;
        for(int i = 0 ; i < nums.length-1 ;  i ++){
            calculate = Math.max(calculate , i + nums[i]);

            if(i == currpost){
                jump++;
                currpost = calculate;
            }
        }
        return jump;
    }
}