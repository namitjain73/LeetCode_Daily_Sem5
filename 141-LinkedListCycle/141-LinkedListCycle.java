// Last updated: 7/9/2026, 5:24:00 PM
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode Fast = head;
        while(Fast != null && Fast.next != null){
            slow = slow.next;
            Fast = Fast.next.next;
            if(slow == Fast) return true;
        }
        return false;
    }
}