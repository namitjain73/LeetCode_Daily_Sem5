// Last updated: 5/9/2026, 3:36:10 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14        ListNode a = headA;
15        ListNode b = headB;
16
17        while(a != b){
18            if(a == null) a = headA;
19            else a = a.next;
20            if(b == null) b = headB;
21            else b = b.next;
22        }
23        return a;
24
25    }
26}