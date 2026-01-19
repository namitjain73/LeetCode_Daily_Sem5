// Last updated: 1/19/2026, 10:57:08 PM
1class Solution {
2    public int totalSteps(int[] nums) {
3        Stack<int[]> st = new Stack<>();
4        int ans = 0;
5
6        for(int num : nums){
7            int step = 0;
8
9            while(!st.isEmpty() && st.peek()[0] <= num){
10                step = Math.max(step,st.pop()[1]);
11            }
12
13            if(st.isEmpty()) step =0;
14            else step += 1;
15
16            ans = Math.max(ans,step);
17            st.push(new int[]{num,step});
18        }
19        return ans;
20    }
21}