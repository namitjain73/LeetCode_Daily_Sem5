// Last updated: 7/9/2026, 5:21:15 PM
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums2.length];
        for(int i = 0 ; i < nums2.length ; i++){
            ans[i] = nums2[i];
        }
        Stack<Integer> st = new Stack<>();
        Map<Integer ,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < ans.length ; i++){
            while(!st.empty() && ans[st.peek()] < ans[i]){
                ans[st.pop()] = ans[i];
            }
            st.push(i);
        } 

        while(!st.empty()){
            ans[st.pop()] = -1;
        }

        for(int i = 0 ; i < nums2.length ; i++){
            mp.put(nums2[i],ans[i]);
        }

        for(int i = 0 ; i < nums1.length ; i++){
            nums1[i] = mp.get(nums1[i]);
        }

        
        return nums1;

        
    }
}