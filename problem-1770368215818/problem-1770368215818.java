// Last updated: 2/6/2026, 2:26:55 PM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node prev;
6    public Node next;
7    public Node child;
8};
9*/
10
11class Solution {
12    public Node flatten(Node head) {
13        Stack<Node> st = new Stack<>();
14
15        Node curr = head;
16
17        while(curr != null){
18            if(curr.child != null){
19                if(curr.next != null){
20                    st.push(curr.next);
21                }
22                Node pre = curr;
23                curr.next = curr.child;
24                curr.child.prev = curr;
25                curr.child = null;
26            }
27            else if(curr.next == null && !st.isEmpty()){
28                Node nn = st.pop();
29                curr.next = nn;
30                nn.prev = curr;
31            }
32
33            curr = curr.next;
34        }
35        curr = head;
36
37        // while(curr != null) {
38        //     System.out.println(curr.val);
39        //     curr = curr.next;
40        // }
41        return head;
42    }
43}