// Last updated: 6/14/2026, 4:33:23 PM
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
12    public int pairSum(ListNode head) {
13        ListNode pre = null;
14        ListNode slow = head;
15        ListNode fast = head;
16        while(fast != null && fast.next != null){
17            pre = slow;
18            slow = slow.next;
19            fast = fast.next.next;
20        }
21        int ans = 0;
22        pre.next = null;
23        pre = reverse(head);
24        while(pre != null && slow != null){
25            ans = Math.max(ans , slow.val + pre.val);
26            // System.out.println(pre.val);
27            slow = slow.next;
28            pre = pre.next;
29        }
30        return ans;
31    }
32    private ListNode reverse(ListNode head) {
33        ListNode prev = null;
34        ListNode curr = head;
35
36        while (curr != null) {
37            ListNode next = curr.next;
38            curr.next = prev;
39            prev = curr;
40            curr = next;
41        }
42
43        return prev;
44    }
45}