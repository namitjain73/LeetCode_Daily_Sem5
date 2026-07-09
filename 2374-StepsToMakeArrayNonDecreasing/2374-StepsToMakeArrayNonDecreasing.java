// Last updated: 7/9/2026, 5:10:39 PM
class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> st = new Stack<>();
        int res = 0;

        for(int i = 0 ; i < nums.length ; i++){
            int step=0;
            while(!st.isEmpty() && nums[st.peek()[0]] <= nums[i]){
                step = Math.max(step , st.pop()[1]);
            }

            if(st.isEmpty()) step = 0;
            else step++;

            res = Math.max(res,step);
            st.push(new int[]{i,step});
        }
        return res;
    }
}