// Last updated: 6/15/2026, 2:03:44 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode deleteMiddle(ListNode head) {
13        if(head.next == null) return null;
14        if(head.next.next == null) {
15            head.next = null;
16            return head;
17        }
18        ListNode pre = null;
19        ListNode slow = head;
20        ListNode fast = head;
21        while(fast != null && fast.next != null){
22            pre = slow;
23            slow = slow.next;
24            fast = fast.next.next;
25        }
26        pre.next = pre.next.next;
27        return head;
28    }
29}