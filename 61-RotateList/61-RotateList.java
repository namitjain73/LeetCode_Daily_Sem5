// Last updated: 7/9/2026, 5:25:09 PM
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int size = getsize(head);
        k = k % size;
        if(k == 0) return head;
        ListNode temp = head;
        for (int i = 0; i < size - k - 1; i++) {
            temp = temp.next;
        }

        ListNode newhead = temp.next;
        temp.next = null;
        ListNode newtail = newhead;
        while(newtail.next != null){
            newtail = newtail.next;
        }

        newtail.next = head;
        return newhead;

        
    }

    public int getsize(ListNode head){
        int i = 0;
        while(head != null){
            head = head.next;
            i++;
        }
        return i;
    }

   
}