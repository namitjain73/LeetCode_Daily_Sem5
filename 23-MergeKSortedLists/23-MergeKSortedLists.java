// Last updated: 7/9/2026, 5:25:53 PM
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
    public ListNode mergeKLists(ListNode[] list) {

        if(list == null || list.length == 0) return null;
        ListNode head = list[0];

        
        for(int i = 1 ; i < list.length ; i++){
            head  = merge(head  , list[i]);
        }

        return head;
        
    }


    public ListNode merge(ListNode a , ListNode b){
        ListNode head = new ListNode();
        ListNode dummy = head;

        while(a != null && b != null){
            if(a.val < b.val){
                head.next = a;
                a = a.next;
            }
            else{
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }


        if(a != null){
            head.next = a;
        }
        if(b != null){
            head.next = b;
        }

        return dummy.next;
    }
}