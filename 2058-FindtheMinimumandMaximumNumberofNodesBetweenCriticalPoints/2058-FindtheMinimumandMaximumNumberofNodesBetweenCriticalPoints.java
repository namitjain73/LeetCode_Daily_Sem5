// Last updated: 8/31/2026, 11:44:13 PM
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
12    public int[] nodesBetweenCriticalPoints(ListNode head) {
13        List<Integer> ll = new ArrayList<>();
14        ListNode pre = head;
15        int i = 1;
16        head = head.next;
17        while(head.next != null){
18            if( ( head.val > pre.val && head.val > head.next.val) || (head.val < pre.val && head.val < head.next.val) ){
19                ll.add(i);
20            }
21            pre = head;
22            head = head.next;
23            i++;
24        }
25
26        if(ll.size() < 2) return new int[]{-1,-1};
27
28
29        int min = Integer.MAX_VALUE;
30        int max = ll.get(ll.size()-1) - ll.get(0);
31        for(int j = 1 ; j < ll.size() ; j++){
32            min = Math.min(min , ll.get(j) - ll.get(j-1));
33        }
34        return new int[]{min,max};
35    }
36}