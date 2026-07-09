// Last updated: 7/9/2026, 5:25:49 PM
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = head;
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        temp = head;
        int n = count / 2;
        while(n-- > 0){
            int t = temp.val;
            temp.val = temp.next.val;
            temp.next.val = t;
            temp = temp.next.next;
        }
        return dummy;
        
    }
}