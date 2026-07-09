// Last updated: 7/9/2026, 5:21:04 PM
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
    public ListNode swapNodes(ListNode head, int n) {
        ListNode dummy = head;
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        // if(count == n) {
        //     dummy = dummy.next;
        //     return dummy;
        // }
        count = count - n;
        temp = head;
        while(count-- > 0){
            temp = temp.next;
        }
        ListNode temp2 = head;
        n--;
        while(n-- > 0){
            temp2 = temp2.next;
        }

        int t = temp.val;
        temp.val = temp2.val;
        temp2.val = t;
        return dummy;



               
    }
}