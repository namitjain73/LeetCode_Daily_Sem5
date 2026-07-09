// Last updated: 7/9/2026, 5:25:57 PM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == n) {
            dummy = dummy.next;
            return dummy;
        }
        count = count - n-1;
        temp = head;
        while(count-- > 0){
            temp = temp.next;
        }

        if(temp.next == null) temp = null;
        else temp.next = temp.next.next;
        return dummy;

               
    }
}