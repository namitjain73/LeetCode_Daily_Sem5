// Last updated: 5/9/2026, 6:41:52 PM
1class Solution {
2    public ListNode reverseKGroup(ListNode head, int k) {
3        ListNode temp = head;
4        ListNode next = null;
5        ListNode kth = null;
6        ListNode pre = null;
7
8
9        while(temp != null){
10            kth = kthNode(temp,k);
11            if(kth == null){
12                if(pre  != null){
13                    pre.next = temp;
14                    break;
15                }
16            }
17
18            next = kth.next;
19            kth.next = null;
20            reverse(temp);
21            if(temp == head){
22                head = kth;
23
24            }else{
25                pre.next = kth;
26            }
27
28            pre = temp;
29            temp = next;
30        }
31        return head;
32    }
33
34    public ListNode kthNode(ListNode head , int n){
35        n--;
36        while(head != null && n-- > 0){
37            head = head.next;
38        }
39
40        return head;
41    }
42
43    public void reverse(ListNode head){
44        ListNode pre = null;
45        ListNode temp = head;
46
47        while(temp != null){
48            ListNode curr = temp.next;
49            temp.next = pre;
50            pre = temp;
51            temp = curr;
52        }
53    }
54}