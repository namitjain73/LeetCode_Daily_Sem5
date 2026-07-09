// Last updated: 7/9/2026, 5:18:08 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int size = size(head);
        int[] arr = new int[size];
        Stack<Integer> st  = new Stack<>();
        for(int i = 0 ; i < size ; i++){
            arr[i] = head.val;
            head = head.next;
        }
        if(size == 0){
            return arr;
        }
        for(int i = 0 ; i < size ; i++){
            while(!st.empty() && arr[i] > arr[st.peek()]){
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while(!st.empty()){
            arr[st.pop()] = 0;
        }

        return arr;
        


    }

    public int size(ListNode head){
        int n = 0;
        while(head !=null){
            n++;
            head = head.next;
        }
        return n;
    }
}