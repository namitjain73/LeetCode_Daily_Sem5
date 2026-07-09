// Last updated: 7/9/2026, 5:23:54 PM
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode left = head;
        ListNode  mid = getmid(head);
        ListNode right = mid.next;
        mid.next = null;


        left = sortList(left);
        right = sortList(right);
        return mergelist(left , right);
    }

    public ListNode getmid(ListNode list){
        ListNode slow = list;
        ListNode fast= list.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergelist(ListNode list1 , ListNode list2){
        ListNode tail = new ListNode();
        ListNode dummy = tail;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next= list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }

        return dummy.next;
    }
}