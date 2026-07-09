// Last updated: 7/9/2026, 5:07:37 PM
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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode dummy = head;
        ListNode pre = head;
        int c = 0;
        while(dummy != null){
            pre = dummy;
            int n = dummy.val;
            n = n * 2;
            n += c;
            dummy.val = n % 10;
            c = n / 10;
            dummy = dummy.next;
        }
        while(c != 0){
            ListNode temp = new ListNode(c % 10);
            c = c / 10;
            pre.next = temp;
            pre = pre.next;

        }

        head = reverse(head);
        return head;

        
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode dummy = head;

        while(dummy != null){
            ListNode temp =  dummy.next;
            dummy.next = pre;
            pre = dummy;
            dummy = temp;
        }
        return pre;
    }
}