// Last updated: 5/9/2026, 3:29:32 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) { val = x; }
7 * }
8 */
9class Solution {
10    public void deleteNode(ListNode node) {
11        ListNode temp = node;
12        while(temp.next.next != null){
13            temp.val = temp.next.val;
14            temp = temp.next;
15        }
16        temp.val = temp.next.val;
17        temp.next = null;
18    }
19}