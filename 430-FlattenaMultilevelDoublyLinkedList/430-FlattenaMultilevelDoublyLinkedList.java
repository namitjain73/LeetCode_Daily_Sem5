// Last updated: 11/21/2025, 11:45:55 AM
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
        Node dummy = head;
        while(head != null){
            Node next = head.next;
            if(head.child != null){
                Node tail = Tail(head.child);
                System.out.println(tail.val);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;

                if(next != null){
                    tail.next = next;
                    next.prev = tail;
                }
            }
            System.out.println(head.val);
            head = head.next;
        }
        return dummy;
    }
    public Node Tail(Node head){
        Node pre = null;
        while(head != null){
            pre = head;
            if(head.next == null && head.child != null){
                head = head.child;
            }else{
                head = head.next;
            }
        }
        return pre;
    }
}