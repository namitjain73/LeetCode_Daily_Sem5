// Last updated: 2/4/2026, 11:29:23 PM
1class Solution {
2    public int totalSteps(int[] nums) {
3        Stack<int[]> st = new Stack<>();
4        int res = 0;
5
6        for(int i = 0 ; i < nums.length ; i++){
7            int step=0;
8            while(!st.isEmpty() && nums[st.peek()[0]] <= nums[i]){
9                step = Math.max(step , st.pop()[1]);
10            }
11
12            if(st.isEmpty()) step = 0;
13            else step++;
14
15            res = Math.max(res,step);
16            st.push(new int[]{i,step});
17        }
18        return res;
19    }
20}