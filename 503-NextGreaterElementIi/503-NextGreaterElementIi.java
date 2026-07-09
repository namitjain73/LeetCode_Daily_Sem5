// Last updated: 7/9/2026, 5:21:12 PM
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = -1;
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < nums.length*2 ; i++){
            while(!st.empty() && nums[i%n] > nums[st.peek()]){
                ans[st.pop()] = nums[i%n];
            }
            st.push(i%n);
        }

        return ans;
    }
}