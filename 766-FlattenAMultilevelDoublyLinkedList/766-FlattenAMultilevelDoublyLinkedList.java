// Last updated: 7/9/2026, 5:19:56 PM
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<>();

        Node curr = head;

        while(curr != null){
            if(curr.child != null){
                if(curr.next != null){
                    st.push(curr.next);
                }
                Node pre = curr;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            else if(curr.next == null && !st.isEmpty()){
                Node nn = st.pop();
                curr.next = nn;
                nn.prev = curr;
            }

            curr = curr.next;
        }
        curr = head;

        // while(curr != null) {
        //     System.out.println(curr.val);
        //     curr = curr.next;
        // }
        return head;
    }
}