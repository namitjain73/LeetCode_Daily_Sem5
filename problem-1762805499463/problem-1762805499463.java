// Last updated: 11/11/2025, 1:41:39 AM
class Solution {
    public int minOperations(int[] nums) {
        int[] stack = new int[nums.length + 1];
        int top = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (stack[top] > nums[i]) {
                top--;
                ans++;
            }
            if (stack[top] != nums[i])
                stack[++top] = nums[i];
        }
        return ans + top;
    }
}